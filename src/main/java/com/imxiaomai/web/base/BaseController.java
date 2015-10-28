package com.imxiaomai.web.base;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.imxiaomai.base._;
import com.imxiaomai.base.io.StreamUtil;
import com.imxiaomai.base.toolkit.AutoLog;
import com.imxiaomai.base.util.EscapeUtil;
import com.imxiaomai.base.util.Jsoned;

import org.springframework.beans.TypeMismatchException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.*;

import static com.imxiaomai.base._.asMap;

public class BaseController {

	protected static final Charset gbk = EscapeUtil.CHARSET_GBK;

	protected static final Charset utf8 = EscapeUtil.CHARSET_UTF8;

	protected static final String COOKIE_KEY = "xiaomai_data";

	private static final AutoLog errLog = AutoLog.of("error.log");

	public ResponseEntity<String> plain(String msg){
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

	 /* ------------------------- json & util ------------------------- */

	public static final Gson gson = new Gson();
	public static Object buildErrJson(String msg) {
		return buildJson(500, msg);
	}
	public static Object buildJson(int code, String msg) {
		return asMap("code", code, "msg", msg);
	}
	
	public static Object buildJson(int code, String msg, Object data) {
        if(data == null) {
            return asMap("code", code, "msg", msg);
        }else {
            return asMap("code", code, "msg", msg, "data", data);
        }
    }
	
	public static Object buildJsonAddFoo(int code, String msg, Object data) {
		Object o=asMap("foo", data);
        return  _.asMap("code", code, "msg", msg, "data", o);
    }
	

	public static boolean isAjax(HttpServletRequest req) {
		return ServletUtils.isAjax(req);
	}
	public static String getIp(HttpServletRequest req) {
		return ServletUtils.getIp(req);
	}

	public static String sendRedirect(HttpServletResponse resp, String url) throws IOException {
		resp.sendRedirect(url);
		return null;
	}

	public static JsonObject buildErrJson(int code, String msg){
		JsonObject object = new JsonObject();
		object.addProperty("code",code);
		object.addProperty("msg",msg);
		return object;
	}

	
	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public Object handleSQLException(Exception e, HttpServletRequest req, HttpServletResponse resp){
		e.printStackTrace();
		errLog.add(1);
		return buildErrJson(-1,e.getMessage());
	}

	@ExceptionHandler({ MissingServletRequestParameterException.class, TypeMismatchException.class,
			ConversionFailedException.class, IllegalArgumentException.class})
	@ResponseBody
	public Object handleMissParamException(Exception e, HttpServletRequest req, HttpServletResponse resp){
		e.printStackTrace();
		errLog.add(1);
		return buildErrJson(-1,e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String handleCommonException(Exception e, HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		errLog.add(1);
		// jetty插件时，浏览器取消请求会产生此Exception，别打log了
		if (e.getClass().getName().equals("org.eclipse.jetty.io.EofException")) {
			return "jetty error";
		}

		// demo期间，打开所有异常stackTrace
		System.err.println("------------------------------------------------------------");
		System.err.println("err on request: " + ServletUtils.getUrl(req));
		e.printStackTrace(System.err);
		System.err.println("------------------------------------------------------------");

		if (isAjax(req)) {
			Object json = buildJson(500, e.getMessage());
			resp.setStatus(500);
			resp.getWriter().print(gson.toJson(json));
			return null;
		} else {
			return buildErrJson(-1,e.getClass().getSimpleName()).toString();
		}
	}

    public String buildRetJson(int code,String msg,JsonObject jsoneds) throws SQLException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("code",code);
        jsonObject.addProperty("msg",msg);

        jsonObject.add("data",jsoneds);
        return jsonObject.toString();
    }

	public <T extends Jsoned> String buildRetJson(int code,String msg,T ele) throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",code);
		jsonObject.addProperty("msg",msg);
		jsonObject.add("data",ele.toJson());
		return jsonObject.toString();
	}

	public String buildRetJson(int code,String msg,List<? extends Jsoned> jsoneds) throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",code);
		jsonObject.addProperty("msg",msg);

		JsonArray array = new JsonArray();
		for( Jsoned ele : jsoneds ){
			if( ele != null )
				array.add(ele.toJson());
		}

		JsonObject tmp = new JsonObject();
		tmp.add("foo",array);
		jsonObject.add("data",tmp);
		return jsonObject.toString();
	}
	
	public JsonObject retJson(int code,String msg,List<? extends Jsoned> jsoneds) throws SQLException {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("code",code);
		jsonObject.addProperty("msg",msg);

		JsonArray array = new JsonArray();
		for( Jsoned ele : jsoneds ){
			if( ele != null )
				array.add(ele.toJson());
		}

		JsonObject tmp = new JsonObject();
		tmp.add("foo",array);
		jsonObject.add("data",tmp);
		return jsonObject;
	}

	
	public String getDataFromRequest(HttpServletRequest request) throws IOException {
		byte[] bytes = StreamUtil.consume(request.getInputStream());
		String data =  new String(bytes,"UTF-8");
		request.setAttribute("raw", data);
		return data;
	}

	public static ResponseEntity<String> plainText(String body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

	public static ResponseEntity<String> plainText(String body,Charset charset) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( new MediaType("text","plain", charset) );
		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

	public static ResponseEntity<String> plainJson(String body,Charset charset) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( new MediaType("application","json", charset) );
		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

	public static ResponseEntity<byte[]> binStream(byte[] datas){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType( new MediaType("","") );
		return new ResponseEntity<>(datas,headers,HttpStatus.OK);
	}

}
