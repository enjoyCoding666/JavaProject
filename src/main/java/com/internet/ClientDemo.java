package com.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientDemo {
	public static void main(String[] args) throws Exception{
		Socket client=null;
		//指定连接的主机和端口
		client=new Socket("localhost",8888);
		BufferedReader buf=null;
		//取得客户端的输入流
		buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str=buf.readLine();
		System.out.println("服务器输出的内容为："+str);
		client.close();
		buf.close();

	}
}
