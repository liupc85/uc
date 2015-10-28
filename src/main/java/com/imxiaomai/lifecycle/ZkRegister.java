//package com.imxiaomai.lifecycle;
//
//import com.imxiaomai.base.infrastructure.Config;
//import com.imxiaomai.base.infrastructure.Module;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.framework.state.ConnectionState;
//import org.apache.curator.framework.state.ConnectionStateListener;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.data.Stat;
//
//import static com.imxiaomai.base._.toInt;
//
//public class ZkRegister {
//
//	private static final boolean isDebug = Boolean.valueOf(Config.of("isdebug", "true").get());
//
//	private static String registerPath = Config.of("zookeeper.register.path","/server/userCenter/1.0").get();
//
//	private static final String ip = IPUtil.selectInternalIp();
//
//	private static int runPort = toInt( Config.of("runPort", "8090").get(), 8090 );
//
//	private static final String zookeeper = Config.of("zookeeper.address","192.168.10.8:2181,192.168.10.13:2181,192.168.10.16:2181").get();
//
//	private static final int interval = toInt(Config.of("zookeeper.retry.interval","1000").get(), 1000);
//
//	private static final int times = toInt(Config.of("zookeeper.retry.times","3").get(), 3);
//
//	private static final int connectionTimeout = toInt(Config.of("zookeeper.connection.timeout","10000").get(), 10000);
//
//	private static final int sessionTimeout = toInt(Config.of("zookeeper.session.timeout","10000").get(), 10000);
//
//	private static final ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(interval, times);
//
//	private static CuratorFramework client;
//
//	private static void initClient(){
//		if( client == null )
//			client = CuratorFrameworkFactory.builder().
//					connectString(zookeeper).
//					retryPolicy(retryPolicy).
//					connectionTimeoutMs(connectionTimeout).
//					sessionTimeoutMs(sessionTimeout).build();
//		client.start();
//
//		client.getConnectionStateListenable().addListener(new ConnectionStateListener() {
//			@Override
//			public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {
//				if( connectionState == ConnectionState.LOST ){
//					System.out.println("[error],lost connection to zookeeper...");
//				}
//
//				if( connectionState == ConnectionState.RECONNECTED ){
//					System.out.println("[warn],reconnect connection to zookeeper...");
//					try {
//						registerPath();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//
//			}
//		});
//
//	}
//
//	private static void destoryClient(){
//		if( client != null )
//			client.close();
//	}
//
//	private static void registerPath() throws Exception {
//		if( client == null || runPort == 0 )
//			throw new IllegalArgumentException("客户端或者端口号未指定");
//
//		String path = registerPath + "/" + ip + ":" + runPort;
//		if( isDebug ) {
//			path = "/debug" + path;
//		}
//
//		Stat stat = client.checkExists().forPath(path);
//		if (stat == null) {
//			client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, (ip + ":" + runPort).getBytes("UTF-8"));
//		}
//	}
//
//	private static void deletePath() throws Exception {
//		if( client != null ){
//			String path = registerPath + "/" + ip + ":" + runPort;
//			if( isDebug )
//				path = "/debug" + path;
//			client.delete().forPath(path);
//		}
//	}
//
//	public static class ZkRegisterModule extends Module{
//		@Override
//		public String name() {
//			return "zookeeper.init.server.register";
//		}
//
//		@Override
//		public void moduleStartup() throws Exception {
//			initClient();
//			registerPath();
//		}
//
//		@Override
//		public void moduleShutdown() throws Exception {
//			deletePath();
//			destoryClient();
//		}
//	}
//
//}