package com.internet;

import java.net.InetAddress;

public class InetAddressDemo {
	public static void main(String[] args) throws Exception{
		InetAddress locAdd=null;
		InetAddress remAdd=null;
		//得到本地的InetAddress对象
		locAdd=InetAddress.getLocalHost();
		//取得远程InetAddress对象
		remAdd=InetAddress.getByName("www.baidu.com");
		System.out.println("百度的IP地址"+remAdd.getHostAddress());
		System.out.println("本机的IP地址"+locAdd.getHostAddress());
		System.out.println("本机是否可达"+locAdd.isReachable(5000));
	}
}
