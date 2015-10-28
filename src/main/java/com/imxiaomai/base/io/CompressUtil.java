package com.imxiaomai.base.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DeflaterInputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

/** (主要用于缓存的)gzip压缩/解压 */
public class CompressUtil {

	public static byte[] compress(byte[] data) throws IOException {
		if (data == null)
			return null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DeflaterOutputStream deflater = new DeflaterOutputStream(out);
		deflater.write(data);
		deflater.close();
		return out.toByteArray();
	}
	public static byte[] compress(InputStream is) throws IOException {
		if (is == null)
			return null;
		is = new DeflaterInputStream(is);
		return StreamUtil.consume(is);
	}
	public static byte[] compress(String string, String charset) throws IOException {
		if (string == null)
			return null;
		return compress(string.getBytes(charset));
	}

	public static byte[] decompress(byte[] data) throws IOException {
		if (data == null)
			return null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InflaterOutputStream inflater = new InflaterOutputStream(out);
		inflater.write(data);
		inflater.close();
		return out.toByteArray();
	}
	public static InputStream decompressToStream(byte[] data) {
		if (data == null)
			return null;
		return new InflaterInputStream(new ByteArrayInputStream(data));
	}
	public static String decompressToString(byte[] data, String charset) throws IOException {
		if (data == null)
			return null;
		return new String(decompress(data), charset);
	}

}
