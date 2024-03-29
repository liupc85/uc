package com.imxiaomai.base.crawler;

import org.apache.commons.logging.Log;
import org.apache.http.*;
import org.apache.http.auth.AuthProtocolState;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.*;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.*;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.ConnectionShutdownException;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * 为增加分阶段计时而修改的DefaultRequestDirector。
 * 此类基本从DefaultRequestDirector复制而来，只添加了几个stage的log
 */
public class MyRequestDirector implements RequestDirector {


	/* ------------------------- constants ------------------------- */
	// 所有修改都是为了这几个标记
	static final CrawlStage __stage_round_start = CrawlStage.round_start;
	static final CrawlStage __stage_conn_end_2 = CrawlStage.conn_end_2;
	static final CrawlStage __stage_exec_start = CrawlStage.exec_start;
	static final CrawlStage __stage_exec_end = CrawlStage.exec_end;


	private final Log log;

	/** The connection manager. */
	protected final ClientConnectionManager connManager;

	/** The route planner. */
	protected final HttpRoutePlanner routePlanner;

	/** The connection re-use strategy. */
	protected final ConnectionReuseStrategy reuseStrategy;

	/** The keep-alive duration strategy. */
	protected final ConnectionKeepAliveStrategy keepAliveStrategy;

	/** The request executor. */
	protected final HttpRequestExecutor requestExec;

	/** The HTTP protocol processor. */
	protected final HttpProcessor httpProcessor;

	/** The request retry handler. */
	protected final HttpRequestRetryHandler retryHandler;

	/** The redirect strategy. */
	protected final RedirectStrategy redirectStrategy;

	/** The target authentication handler. */
	protected final AuthenticationStrategy targetAuthStrategy;

	/** The proxy authentication handler. */
	protected final AuthenticationStrategy proxyAuthStrategy;

	/** The user token handler. */
	protected final UserTokenHandler userTokenHandler;

	/** The HTTP parameters. */
	protected final HttpParams params;

	/** The currently allocated connection. */
	protected ManagedClientConnection managedConn;

	protected final AuthState targetAuthState;

	protected final AuthState proxyAuthState;

	private final HttpAuthenticator authenticator;

	private int execCount;

	private int redirectCount;

	private int maxRedirects;

	private HttpHost virtualHost;

	/**
	 * @since 4.2
	 */
	public MyRequestDirector(
			final Log log,
			final HttpRequestExecutor requestExec,
			final ClientConnectionManager conman,
			final ConnectionReuseStrategy reustrat,
			final ConnectionKeepAliveStrategy kastrat,
			final HttpRoutePlanner rouplan,
			final HttpProcessor httpProcessor,
			final HttpRequestRetryHandler retryHandler,
			final RedirectStrategy redirectStrategy,
			final AuthenticationStrategy targetAuthStrategy,
			final AuthenticationStrategy proxyAuthStrategy,
			final UserTokenHandler userTokenHandler,
			final HttpParams params) {

		if (log == null) {
			throw new IllegalArgumentException
					("Log may not be null.");
		}
		if (requestExec == null) {
			throw new IllegalArgumentException
					("Request executor may not be null.");
		}
		if (conman == null) {
			throw new IllegalArgumentException
					("Client connection manager may not be null.");
		}
		if (reustrat == null) {
			throw new IllegalArgumentException
					("Connection reuse strategy may not be null.");
		}
		if (kastrat == null) {
			throw new IllegalArgumentException
					("Connection keep alive strategy may not be null.");
		}
		if (rouplan == null) {
			throw new IllegalArgumentException
					("Route planner may not be null.");
		}
		if (httpProcessor == null) {
			throw new IllegalArgumentException
					("HTTP protocol processor may not be null.");
		}
		if (retryHandler == null) {
			throw new IllegalArgumentException
					("HTTP request retry handler may not be null.");
		}
		if (redirectStrategy == null) {
			throw new IllegalArgumentException
					("Redirect strategy may not be null.");
		}
		if (targetAuthStrategy == null) {
			throw new IllegalArgumentException
					("Target authentication strategy may not be null.");
		}
		if (proxyAuthStrategy == null) {
			throw new IllegalArgumentException
					("Proxy authentication strategy may not be null.");
		}
		if (userTokenHandler == null) {
			throw new IllegalArgumentException
					("User token handler may not be null.");
		}
		if (params == null) {
			throw new IllegalArgumentException
					("HTTP parameters may not be null");
		}
		this.log = log;
		this.authenticator = new HttpAuthenticator(log);
		this.requestExec = requestExec;
		this.connManager = conman;
		this.reuseStrategy = reustrat;
		this.keepAliveStrategy = kastrat;
		this.routePlanner = rouplan;
		this.httpProcessor = httpProcessor;
		this.retryHandler = retryHandler;
		this.redirectStrategy = redirectStrategy;
		this.targetAuthStrategy = targetAuthStrategy;
		this.proxyAuthStrategy = proxyAuthStrategy;
		this.userTokenHandler = userTokenHandler;
		this.params = params;

		this.managedConn = null;

		this.execCount = 0;
		this.redirectCount = 0;
		this.targetAuthState = new AuthState();
		this.proxyAuthState = new AuthState();
		this.maxRedirects = this.params.getIntParameter(ClientPNames.MAX_REDIRECTS, 100);
	}


	private RequestWrapper wrapRequest(
			final HttpRequest request) throws ProtocolException {
		if (request instanceof HttpEntityEnclosingRequest) {
			return new EntityEnclosingRequestWrapper(
					(HttpEntityEnclosingRequest) request);
		} else {
			return new RequestWrapper(
					request);
		}
	}


	protected void rewriteRequestURI(
			final RequestWrapper request,
			final HttpRoute route) throws ProtocolException {
		try {

			URI uri = request.getURI();
			if (route.getProxyHost() != null && !route.isTunnelled()) {
				// Make sure the request URI is absolute
				if (!uri.isAbsolute()) {
					HttpHost target = route.getTargetHost();
					uri = URIUtils.rewriteURI(uri, target, true);
				} else {
					uri = URIUtils.rewriteURI(uri);
				}
			} else {
				// Make sure the request URI is relative
				if (uri.isAbsolute()) {
					uri = URIUtils.rewriteURI(uri, null, true);
				} else {
					uri = URIUtils.rewriteURI(uri);
				}
			}
			request.setURI(uri);

		} catch (URISyntaxException ex) {
			throw new ProtocolException("Invalid URI: " +
					request.getRequestLine().getUri(), ex);
		}
	}


	// non-javadoc, see interface ClientRequestDirector
	public HttpResponse execute(HttpHost target, HttpRequest request,
								HttpContext context)
			throws HttpException, IOException {

		context.setAttribute(ClientContext.TARGET_AUTH_STATE, targetAuthState);
		context.setAttribute(ClientContext.PROXY_AUTH_STATE, proxyAuthState);

		HttpRequest orig = request;
		RequestWrapper origWrapper = wrapRequest(orig);
		origWrapper.setParams(params);
		HttpRoute origRoute = determineRoute(target, origWrapper, context);

		virtualHost = (HttpHost) origWrapper.getParams().getParameter(ClientPNames.VIRTUAL_HOST);

		// HTTPCLIENT-1092 - add the port if necessary
		if (virtualHost != null && virtualHost.getPort() == -1) {
			HttpHost host = (target != null) ? target : origRoute.getTargetHost();
			int port = host.getPort();
			if (port != -1) {
				virtualHost = new HttpHost(virtualHost.getHostName(), port, virtualHost.getSchemeName());
			}
		}

		RoutedRequest roureq = new RoutedRequest(origWrapper, origRoute);

		boolean reuse = false;
		boolean done = false;
		try {
			HttpResponse response = null;
			while (!done) {
				__stage_round_start.log(context);

				// In this loop, the RoutedRequest may be replaced by a
				// followup request and route. The request and route passed
				// in the method arguments will be replaced. The original
				// request is still available in 'orig'.

				RequestWrapper wrapper = roureq.getRequest();
				HttpRoute route = roureq.getRoute();
				response = null;

				// See if we have a user token bound to the execution context
				Object userToken = context.getAttribute(ClientContext.USER_TOKEN);

				// Allocate connection if needed
				if (managedConn == null) {
					ClientConnectionRequest connRequest = connManager.requestConnection(
							route, userToken);
					if (orig instanceof AbortableHttpRequest) {
						((AbortableHttpRequest) orig).setConnectionRequest(connRequest);
					}

					long timeout = HttpClientParams.getConnectionManagerTimeout(params);
					try {
						managedConn = connRequest.getConnection(timeout, TimeUnit.MILLISECONDS);
					} catch (InterruptedException interrupted) {
						Thread.currentThread().interrupt();
						throw new InterruptedIOException();
					}

					if (HttpConnectionParams.isStaleCheckingEnabled(params)) {
						// validate connection
						if (managedConn.isOpen()) {
							this.log.debug("Stale connection check");
							if (managedConn.isStale()) {
								this.log.debug("Stale connection detected");
								managedConn.close();
							}
						}
					}
				}

				if (orig instanceof AbortableHttpRequest) {
					((AbortableHttpRequest) orig).setReleaseTrigger(managedConn);
				}

				try {
					tryConnect(roureq, context);
				} catch (TunnelRefusedException ex) {
					if (this.log.isDebugEnabled()) {
						this.log.debug(ex.getMessage());
					}
					response = ex.getResponse();
					break;
				} finally {
					__stage_conn_end_2.log(context);
				}

				String userinfo = wrapper.getURI().getUserInfo();
				if (userinfo != null) {
					targetAuthState.update(
							new BasicScheme(), new UsernamePasswordCredentials(userinfo));
				}

				HttpHost proxy = route.getProxyHost();
				if (virtualHost != null) {
					target = virtualHost;
				} else {
					URI requestURI = wrapper.getURI();
					if (requestURI.isAbsolute()) {
						target = URIUtils.extractHost(requestURI);
					}
				}
				if (target == null) {
					target = route.getTargetHost();
				}

				// Reset headers on the request wrapper
				wrapper.resetHeaders();
				// Re-write request URI if needed
				rewriteRequestURI(wrapper, route);

				// Populate the execution context
				context.setAttribute(ExecutionContext.HTTP_TARGET_HOST, target);
				context.setAttribute(ExecutionContext.HTTP_PROXY_HOST, proxy);
				context.setAttribute(ExecutionContext.HTTP_CONNECTION, managedConn);

				// Run request protocol interceptors
				requestExec.preProcess(wrapper, httpProcessor, context);

				__stage_exec_start.log(context);
				response = tryExecute(roureq, context);
				__stage_exec_end.log(context);
				if (response == null) {
					// Need to start over
					continue;
				}

				// Run response protocol interceptors
				response.setParams(params);
				requestExec.postProcess(response, httpProcessor, context);


				// The connection is in or can be brought to a re-usable state.
				reuse = reuseStrategy.keepAlive(response, context);
				if (reuse) {
					// Set the idle duration of this connection
					long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
					if (this.log.isDebugEnabled()) {
						String s;
						if (duration > 0) {
							s = "for " + duration + " " + TimeUnit.MILLISECONDS;
						} else {
							s = "indefinitely";
						}
						this.log.debug("Connection can be kept alive " + s);
					}
					managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
				}

				RoutedRequest followup = handleResponse(roureq, response, context);
				if (followup == null) {
					done = true;
				} else {
					if (reuse) {
						// Make sure the response body is fully consumed, if present
						HttpEntity entity = response.getEntity();
						EntityUtils.consume(entity);
						// entity consumed above is not an auto-release entity,
						// need to mark the connection re-usable explicitly
						managedConn.markReusable();
					} else {
						managedConn.close();
						if (proxyAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) > 0
								&& proxyAuthState.getAuthScheme() != null
								&& proxyAuthState.getAuthScheme().isConnectionBased()) {
							this.log.debug("Resetting proxy auth state");
							proxyAuthState.reset();
						}
						if (targetAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) > 0
								&& targetAuthState.getAuthScheme() != null
								&& targetAuthState.getAuthScheme().isConnectionBased()) {
							this.log.debug("Resetting target auth state");
							targetAuthState.reset();
						}
					}
					// check if we can use the same connection for the followup
					if (!followup.getRoute().equals(roureq.getRoute())) {
						releaseConnection();
					}
					roureq = followup;
				}

				if (managedConn != null) {
					if (userToken == null) {
						userToken = userTokenHandler.getUserToken(context);
						context.setAttribute(ClientContext.USER_TOKEN, userToken);
					}
					if (userToken != null) {
						managedConn.setState(userToken);
					}
				}

			} // while not done


			// check for entity, release connection if possible
			if ((response == null) || (response.getEntity() == null) ||
					!response.getEntity().isStreaming()) {
				// connection not needed and (assumed to be) in re-usable state
				if (reuse)
					managedConn.markReusable();
				releaseConnection();
			} else {
				// install an auto-release entity
				HttpEntity entity = response.getEntity();
				entity = new BasicManagedEntity(entity, managedConn, reuse);
				response.setEntity(entity);
			}

			return response;

		} catch (ConnectionShutdownException ex) {
			InterruptedIOException ioex = new InterruptedIOException(
					"Connection has been shut down");
			ioex.initCause(ex);
			throw ioex;
		} catch (HttpException ex) {
			abortConnection();
			throw ex;
		} catch (IOException ex) {
			abortConnection();
			throw ex;
		} catch (RuntimeException ex) {
			abortConnection();
			throw ex;
		}
	} // execute

	/**
	 * Establish connection either directly or through a tunnel and retry in case of
	 * a recoverable I/O failure
	 */
	private void tryConnect(
			final RoutedRequest req, final HttpContext context) throws HttpException, IOException {
		HttpRoute route = req.getRoute();
		HttpRequest wrapper = req.getRequest();

		int connectCount = 0;
		for (; ; ) {
			context.setAttribute(ExecutionContext.HTTP_REQUEST, wrapper);
			// Increment connect count
			connectCount++;
			try {
				if (!managedConn.isOpen()) {
					managedConn.open(route, context, params);
				} else {
					managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
				}
				establishRoute(route, context);
				break;
			} catch (IOException ex) {
				try {
					managedConn.close();
				} catch (IOException ignore) {
				}
				if (retryHandler.retryRequest(ex, connectCount, context)) {
					if (this.log.isInfoEnabled()) {
						this.log.info("I/O exception (" + ex.getClass().getName() +
								") caught when connecting to the target host: "
								+ ex.getMessage());
						if (this.log.isDebugEnabled()) {
							this.log.debug(ex.getMessage(), ex);
						}
						this.log.info("Retrying connect");
					}
				} else {
					throw ex;
				}
			}
		}
	}

	/**
	 * Execute request and retry in case of a recoverable I/O failure
	 */
	private HttpResponse tryExecute(
			final RoutedRequest req, final HttpContext context) throws HttpException, IOException {
		RequestWrapper wrapper = req.getRequest();
		HttpRoute route = req.getRoute();
		HttpResponse response = null;

		Exception retryReason = null;
		for (; ; ) {
			// Increment total exec count (with redirects)
			execCount++;
			// Increment exec count for this particular request
			wrapper.incrementExecCount();
			if (!wrapper.isRepeatable()) {
				this.log.debug("Cannot retry non-repeatable request");
				if (retryReason != null) {
					throw new NonRepeatableRequestException("Cannot retry request " +
							"with a non-repeatable request entity.  The cause lists the " +
							"reason the original request failed.", retryReason);
				} else {
					throw new NonRepeatableRequestException("Cannot retry request " +
							"with a non-repeatable request entity.");
				}
			}

			try {
				if (!managedConn.isOpen()) {
					// If we have a direct route to the target host
					// just re-open connection and re-try the request
					if (!route.isTunnelled()) {
						this.log.debug("Reopening the direct connection.");
						managedConn.open(route, context, params);
					} else {
						// otherwise give up
						this.log.debug("Proxied connection. Need to start over.");
						break;
					}
				}

				if (this.log.isDebugEnabled()) {
					this.log.debug("Attempt " + execCount + " to execute request");
				}
				response = requestExec.execute(wrapper, managedConn, context);
				break;

			} catch (IOException ex) {
				this.log.debug("Closing the connection.");
				try {
					managedConn.close();
				} catch (IOException ignore) {
				}
				if (retryHandler.retryRequest(ex, wrapper.getExecCount(), context)) {
					if (this.log.isInfoEnabled()) {
						this.log.info("I/O exception (" + ex.getClass().getName() +
								") caught when processing request: "
								+ ex.getMessage());
					}
					if (this.log.isDebugEnabled()) {
						this.log.debug(ex.getMessage(), ex);
					}
					this.log.info("Retrying request");
					retryReason = ex;
				} else {
					throw ex;
				}
			}
		}
		return response;
	}

	/**
	 * Returns the connection back to the connection manager
	 * and prepares for retrieving a new connection during
	 * the next request.
	 */
	protected void releaseConnection() {
		// Release the connection through the ManagedConnection instead of the
		// ConnectionManager directly.  This lets the connection control how
		// it is released.
		try {
			managedConn.releaseConnection();
		} catch (IOException ignored) {
			this.log.debug("IOException releasing connection", ignored);
		}
		managedConn = null;
	}

	/**
	 * Determines the route for a request.
	 * Called by {@link #execute}
	 * to determine the route for either the original or a followup request.
	 *
	 * @param target    the target host for the request.
	 *                  Implementations may accept <code>null</code>
	 *                  if they can still determine a route, for example
	 *                  to a default target or by inspecting the request.
	 * @param request   the request to execute
	 * @param context   the context to use for the execution,
	 *                  never <code>null</code>
	 *
	 * @return the route the request should take
	 *
	 * @throws org.apache.http.HttpException    in case of a problem
	 */
	protected HttpRoute determineRoute(HttpHost target,
									   HttpRequest request,
									   HttpContext context)
			throws HttpException {

		if (target == null) {
			target = (HttpHost) request.getParams().getParameter(
					ClientPNames.DEFAULT_HOST);
		}
		if (target == null) {
			throw new IllegalStateException
					("Target host must not be null, or set in parameters.");
		}

		return this.routePlanner.determineRoute(target, request, context);
	}


	/**
	 * Establishes the target route.
	 *
	 * @param route     the route to establish
	 * @param context   the context for the request execution
	 *
	 * @throws org.apache.http.HttpException    in case of a problem
	 * @throws java.io.IOException      in case of an IO problem
	 */
	protected void establishRoute(HttpRoute route, HttpContext context)
			throws HttpException, IOException {

		HttpRouteDirector rowdy = new BasicRouteDirector();
		int step;
		do {
			HttpRoute fact = managedConn.getRoute();
			step = rowdy.nextStep(route, fact);

			switch (step) {

				case HttpRouteDirector.CONNECT_TARGET:
				case HttpRouteDirector.CONNECT_PROXY:
					managedConn.open(route, context, this.params);
					break;

				case HttpRouteDirector.TUNNEL_TARGET: {
					boolean secure = createTunnelToTarget(route, context);
					this.log.debug("Tunnel to target created.");
					managedConn.tunnelTarget(secure, this.params);
				}
				break;

				case HttpRouteDirector.TUNNEL_PROXY: {
					// The most simple example for this case is a proxy chain
					// of two proxies, where P1 must be tunnelled to P2.
					// route: Source -> P1 -> P2 -> Target (3 hops)
					// fact:  Source -> P1 -> Target       (2 hops)
					final int hop = fact.getHopCount() - 1; // the hop to establish
					boolean secure = createTunnelToProxy(route, hop, context);
					this.log.debug("Tunnel to proxy created.");
					managedConn.tunnelProxy(route.getHopTarget(hop),
							secure, this.params);
				}
				break;


				case HttpRouteDirector.LAYER_PROTOCOL:
					managedConn.layerProtocol(context, this.params);
					break;

				case HttpRouteDirector.UNREACHABLE:
					throw new HttpException("Unable to establish route: " +
							"planned = " + route + "; current = " + fact);
				case HttpRouteDirector.COMPLETE:
					// do nothing
					break;
				default:
					throw new IllegalStateException("Unknown step indicator "
							+ step + " from RouteDirector.");
			}

		} while (step > HttpRouteDirector.COMPLETE);

	} // establishConnection


	/**
	 * Creates a tunnel to the target server.
	 * The connection must be established to the (last) proxy.
	 * A CONNECT request for tunnelling through the proxy will
	 * be created and sent, the response received and checked.
	 * This method does <i>not</i> update the connection with
	 * information about the tunnel, that is left to the caller.
	 *
	 * @param route     the route to establish
	 * @param context   the context for request execution
	 *
	 * @return  <code>true</code> if the tunnelled route is secure,
	 *          <code>false</code> otherwise.
	 *          The implementation here always returns <code>false</code>,
	 *          but derived classes may override.
	 *
	 * @throws org.apache.http.HttpException    in case of a problem
	 * @throws java.io.IOException      in case of an IO problem
	 */
	protected boolean createTunnelToTarget(HttpRoute route,
										   HttpContext context)
			throws HttpException, IOException {

		HttpHost proxy = route.getProxyHost();
		HttpHost target = route.getTargetHost();
		HttpResponse response = null;

		for (; ; ) {
			if (!this.managedConn.isOpen()) {
				this.managedConn.open(route, context, this.params);
			}

			HttpRequest connect = createConnectRequest(route, context);
			connect.setParams(this.params);

			// Populate the execution context
			context.setAttribute(ExecutionContext.HTTP_TARGET_HOST, target);
			context.setAttribute(ExecutionContext.HTTP_PROXY_HOST, proxy);
			context.setAttribute(ExecutionContext.HTTP_CONNECTION, managedConn);
			context.setAttribute(ExecutionContext.HTTP_REQUEST, connect);

			this.requestExec.preProcess(connect, this.httpProcessor, context);

			response = this.requestExec.execute(connect, this.managedConn, context);

			response.setParams(this.params);
			this.requestExec.postProcess(response, this.httpProcessor, context);

			int status = response.getStatusLine().getStatusCode();
			if (status < 200) {
				throw new HttpException("Unexpected response to CONNECT request: " +
						response.getStatusLine());
			}

			if (HttpClientParams.isAuthenticating(this.params)) {
				if (this.authenticator.isAuthenticationRequested(proxy, response,
						this.proxyAuthStrategy, this.proxyAuthState, context)) {
					if (this.authenticator.authenticate(proxy, response,
							this.proxyAuthStrategy, this.proxyAuthState, context)) {
						// Retry request
						if (this.reuseStrategy.keepAlive(response, context)) {
							this.log.debug("Connection kept alive");
							// Consume response content
							HttpEntity entity = response.getEntity();
							EntityUtils.consume(entity);
						} else {
							this.managedConn.close();
						}
					} else {
						break;
					}
				} else {
					break;
				}
			}
		}

		int status = response.getStatusLine().getStatusCode();

		if (status > 299) {

			// Buffer response content
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				response.setEntity(new BufferedHttpEntity(entity));
			}

			this.managedConn.close();
			throw new TunnelRefusedException("CONNECT refused by proxy: " +
					response.getStatusLine(), response);
		}

		this.managedConn.markReusable();

		// How to decide on security of the tunnelled connection?
		// The socket factory knows only about the segment to the proxy.
		// Even if that is secure, the hop to the target may be insecure.
		// Leave it to derived classes, consider insecure by default here.
		return false;

	} // createTunnelToTarget



	/**
	 * Creates a tunnel to an intermediate proxy.
	 * This method is <i>not</i> implemented in this class.
	 * It just throws an exception here.
	 *
	 * @param route     the route to establish
	 * @param hop       the hop in the route to establish now.
	 *                  <code>route.getHopTarget(hop)</code>
	 *                  will return the proxy to tunnel to.
	 * @param context   the context for request execution
	 *
	 * @return  <code>true</code> if the partially tunnelled connection
	 *          is secure, <code>false</code> otherwise.
	 *
	 * @throws org.apache.http.HttpException    in case of a problem
	 * @throws java.io.IOException      in case of an IO problem
	 */
	protected boolean createTunnelToProxy(HttpRoute route, int hop,
										  HttpContext context)
			throws HttpException, IOException {

		// Have a look at createTunnelToTarget and replicate the parts
		// you need in a custom derived class. If your proxies don't require
		// authentication, it is not too hard. But for the stock version of
		// HttpClient, we cannot make such simplifying assumptions and would
		// have to include proxy authentication code. The HttpComponents team
		// is currently not in a position to support rarely used code of this
		// complexity. Feel free to submit patches that refactor the code in
		// createTunnelToTarget to facilitate re-use for proxy tunnelling.

		throw new HttpException("Proxy chains are not supported.");
	}



	/**
	 * Creates the CONNECT request for tunnelling.
	 * Called by {@link #createTunnelToTarget createTunnelToTarget}.
	 *
	 * @param route     the route to establish
	 * @param context   the context for request execution
	 *
	 * @return the CONNECT request for tunnelling
	 */
	protected HttpRequest createConnectRequest(HttpRoute route,
											   HttpContext context) {
		// see RFC 2817, section 5.2 and
		// INTERNET-DRAFT: Tunneling TCP based protocols through
		// Web proxy servers

		HttpHost target = route.getTargetHost();

		String host = target.getHostName();
		int port = target.getPort();
		if (port < 0) {
			Scheme scheme = connManager.getSchemeRegistry().
					getScheme(target.getSchemeName());
			port = scheme.getDefaultPort();
		}

		StringBuilder buffer = new StringBuilder(host.length() + 6);
		buffer.append(host);
		buffer.append(':');
		buffer.append(Integer.toString(port));

		String authority = buffer.toString();
		ProtocolVersion ver = HttpProtocolParams.getVersion(params);
		HttpRequest req = new BasicHttpRequest
				("CONNECT", authority, ver);

		return req;
	}


	/**
	 * Analyzes a response to check need for a followup.
	 *
	 * @param roureq    the request and route.
	 * @param response  the response to analayze
	 * @param context   the context used for the current request execution
	 *
	 * @return the followup request and route if there is a followup, or
	 *          <code>null</code> if the response should be returned as is
	 *
	 * @throws org.apache.http.HttpException    in case of a problem
	 * @throws java.io.IOException      in case of an IO problem
	 */
	protected RoutedRequest handleResponse(RoutedRequest roureq,
										   HttpResponse response,
										   HttpContext context)
			throws HttpException, IOException {

		HttpRoute route = roureq.getRoute();
		RequestWrapper request = roureq.getRequest();

		HttpParams params = request.getParams();

		if (HttpClientParams.isAuthenticating(params)) {
			HttpHost target = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
			if (target == null) {
				target = route.getTargetHost();
			}
			if (target.getPort() < 0) {
				Scheme scheme = connManager.getSchemeRegistry().getScheme(target);
				target = new HttpHost(target.getHostName(), scheme.getDefaultPort(), target.getSchemeName());
			}
			if (this.authenticator.isAuthenticationRequested(target, response,
					this.targetAuthStrategy, this.targetAuthState, context)) {
				if (this.authenticator.authenticate(target, response,
						this.targetAuthStrategy, this.targetAuthState, context)) {
					// Re-try the same request via the same route
					return roureq;
				}
			}

			HttpHost proxy = route.getProxyHost();
			if (this.authenticator.isAuthenticationRequested(proxy, response,
					this.proxyAuthStrategy, this.proxyAuthState, context)) {
				// if proxy is not set use target host instead
				if (proxy == null) {
					proxy = route.getTargetHost();
				}
				if (this.authenticator.authenticate(proxy, response,
						this.proxyAuthStrategy, this.proxyAuthState, context)) {
					// Re-try the same request via the same route
					return roureq;
				}
			}
		}

		if (HttpClientParams.isRedirecting(params) &&
				this.redirectStrategy.isRedirected(request, response, context)) {

			if (redirectCount >= maxRedirects) {
				throw new RedirectException("Maximum redirects ("
						+ maxRedirects + ") exceeded");
			}
			redirectCount++;

			// Virtual host cannot be used any longer
			virtualHost = null;

			HttpUriRequest redirect = redirectStrategy.getRedirect(request, response, context);
			HttpRequest orig = request.getOriginal();
			redirect.setHeaders(orig.getAllHeaders());

			URI uri = redirect.getURI();
			HttpHost newTarget = URIUtils.extractHost(uri);
			if (newTarget == null) {
				throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
			}

			// Reset auth states if redirecting to another host
			if (!route.getTargetHost().equals(newTarget)) {
				this.log.debug("Resetting target auth state");
				targetAuthState.reset();
				AuthScheme authScheme = proxyAuthState.getAuthScheme();
				if (authScheme != null && authScheme.isConnectionBased()) {
					this.log.debug("Resetting proxy auth state");
					proxyAuthState.reset();
				}
			}

			RequestWrapper wrapper = wrapRequest(redirect);
			wrapper.setParams(params);

			HttpRoute newRoute = determineRoute(newTarget, wrapper, context);
			RoutedRequest newRequest = new RoutedRequest(wrapper, newRoute);

			if (this.log.isDebugEnabled()) {
				this.log.debug("Redirecting to '" + uri + "' via " + newRoute);
			}

			return newRequest;
		}

		return null;
	} // handleResponse


	/**
	 * Shuts down the connection.
	 * This method is called from a <code>catch</code> block in
	 * {@link #execute execute} during exception handling.
	 */
	private void abortConnection() {
		ManagedClientConnection mcc = managedConn;
		if (mcc != null) {
			// we got here as the result of an exception
			// no response will be returned, release the connection
			managedConn = null;
			try {
				mcc.abortConnection();
			} catch (IOException ex) {
				if (this.log.isDebugEnabled()) {
					this.log.debug(ex.getMessage(), ex);
				}
			}
			// ensure the connection manager properly releases this connection
			try {
				mcc.releaseConnection();
			} catch (IOException ignored) {
				this.log.debug("Error releasing connection", ignored);
			}
		}
	} // abortConnection

}
