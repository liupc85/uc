package com.imxiaomai.base.digt;

import com.imxiaomai.base.util.EscapeUtil;

import java.security.MessageDigest;

public class Md5Util {

	/** @return byte[16] */
	public static byte[] md5(byte[] bytes) {
		if (bytes == null)
			throw new IllegalArgumentException();
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			return digest.digest(bytes);
		} catch (Exception e) {
			return null;
		}
	}
	/** @return byte[16] */
	public static byte[] md5(String s) {
		return md5(toBytes(s));
	}
	/** @return String[32] */
	public static String md5AsUpperHex(String s) {
		return md5AsUpperHex(toBytes(s));
	}
	/** @return String[32] */
	public static String md5AsLowerHex(String s) {
		return md5AsLowerHex(toBytes(s));
	}
	/** @return String[32] */
	public static String md5AsUpperHex(byte[] bytes) {
		return asHex(md5(bytes), false);
	}
	/** @return String[32] */
	public static String md5AsLowerHex(byte[] bytes) {
		return asHex(md5(bytes), true);
	}

	/* ------------------------- impl ------------------------- */

	private static byte[] toBytes(String s) {
		return (s != null ? s : "").getBytes(EscapeUtil.CHARSET_UTF8);
	}
	private static final char[] HEX_CHARS_LOWER = "0123456789abcdef".toCharArray();
	private static final char[] HEX_CHARS_UPPER = "0123456789ABCDEF".toCharArray();
	private static String asHex(byte[] bytes, boolean lowerCase) {
		if (bytes == null || bytes.length != 16)
			throw new IllegalArgumentException();

		char[] template = lowerCase ? HEX_CHARS_LOWER : HEX_CHARS_UPPER;
		char chars[] = new char[32];
		for (int i = 0; i < chars.length; i = i + 2) {
			byte b = bytes[i / 2];
			chars[i] = template[(b >>> 4) & 0xf];
			chars[i + 1] = template[b & 0xf];
		}
		return new String(chars);
	}
	public static void main(String[] args){
		String pwd = "12345678";
		String pwdMD5 = "331929ca1114bcfa38e1e17834551c82";
		String pwdMD52 = Md5Util.md5AsLowerHex(pwd);
		System.out.println("1:" + pwdMD5);
		System.out.println("2:" + pwdMD52);

	}
}
