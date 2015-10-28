/**
 * @FileName: TokenUtil.java
 * @Package com.imxiaomai.api.util
 *
 * @author liangchengyu
 * @created 2014年5月14日 下午4:06:11
 *
 * Copyright 2013-2050 小麦公社 版权所有
 */
package com.imxiaomai.util;

import com.imxiaomai.base.digt.Md5Util;

import java.io.UnsupportedEncodingException;

public class TokenUtils {

	private static final String AUTHENTICATE_KEY = "EEE25CE9DAD833D8B7BB6463A5668133";

	public static String getToken(long userid, String password) throws UnsupportedEncodingException {
		byte[] bs = (userid + password + AUTHENTICATE_KEY).getBytes("UTF-8");
		return Md5Util.md5AsLowerHex(bs);
	}

}
