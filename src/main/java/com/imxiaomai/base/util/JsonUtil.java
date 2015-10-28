package com.imxiaomai.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imxiaomai.base._;

import java.io.IOException;
import java.io.Writer;

public class JsonUtil {

	public static String format(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	public static void format(Object obj, Writer out) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, obj);
	}

	public static JsonNode parse(String json) throws IOException {
		return new ObjectMapper().readTree(json);
	}

	public static void main(String[] args) {
		try {
			String jsonString = format(_.asMap("userId", 1, "userName", "lpc", "phone", 12344, "collegeId", 11, "createTime", "134234567", "collegeName", "学校"));
			System.out.println(jsonString);
			System.out.println(format( _.asMap("token", "11111111111111111", "UserInfo",jsonString)));
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
	}
	
}
