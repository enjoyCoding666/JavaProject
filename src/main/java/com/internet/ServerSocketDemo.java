package com.internet;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket server=null;   //定义ServerSocket对象，表示 服务器
		Socket client=null;        //定义Socket对象，表示 客户端
		server=new ServerSocket(8888);
		boolean flag=true;
		while(flag){
			System.out.println("服务器运行，等待客户端连接");
			client=server.accept();   //接收客户端连接
			new Thread(new EchoThread(client)).start();
		}
		server.close();
	}

}
