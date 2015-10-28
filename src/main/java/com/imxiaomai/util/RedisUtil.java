package com.imxiaomai.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.imxiaomai.fw.client.codis.CommonClient;
import com.imxiaomai.fw.client.codis.pool.PoolType;

public class RedisUtil {
	
	
	private static String tryNum = ConfigUtil.getStringValue("codis.trynum");
	private static CommonClient commonClient = new CommonClient(PoolType.roundRobin, Integer.parseInt(tryNum));
	
	public static Boolean set(String key, Integer expireTime,  String value){
		return commonClient.setex(key, expireTime, value);
	}
	
	public static Object get(String key){
		return commonClient.get(key);
	}
	
	public static Long del(String...keys){
		return commonClient.del(keys);
	}
	
	
	public static  byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
		//序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();;
			return null;
		}
	}
	
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
		//反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return e;
		}
	}
	
}
