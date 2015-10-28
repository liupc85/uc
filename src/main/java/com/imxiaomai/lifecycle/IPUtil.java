package com.imxiaomai.lifecycle;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

public class IPUtil {

	public static final List<String> getIP(){
		List<String> ips = new ArrayList<>();
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();

				if (networkInterface.isLoopback() || networkInterface.isVirtual() || networkInterface.isPointToPoint())
					continue;

				Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
				while (inetAddressEnumeration.hasMoreElements()) {
					InetAddress address = inetAddressEnumeration.nextElement();
					if (address.isSiteLocalAddress())
						ips.add(address.getHostAddress());
				}
			}
		}catch (SocketException e){
			e.printStackTrace();
		}

		return ips;
	}

	public static final String selectInternalIp(){
		List<String> allIp = getIP();
		for( String ip : allIp ){
			if( ip.startsWith("10.") || ip.startsWith("192.168.") ){
				return ip;
			}
		}
		throw new NoSuchElementException("内网IP地址不存在");
	}

}