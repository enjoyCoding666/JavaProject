package com.internet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable{
	private Socket client=null;
	public EchoThread(Socket client){
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		PrintStream out=null;
		BufferedReader buf=null;
		try {
			//得到客户端的输入信息
			buf=new BufferedReader(new InputStreamReader(client.getInputStream()));
			out=new PrintStream(client.getOutputStream());
			boolean flag=true;
			while(flag){           //客户端循环操作
				String str=buf.readLine();
				if(str==null || "".equals(str)){
					flag=false;      //如果为空，客户端操作结束。
				}else {
					if("bye".equals(str)){
						flag=false;
					}else {
						out.println("ECHO:"+str);        //向客户端回显信息
					}
				}

			}
			out.close();
			client.close();

		}catch (Exception e){

		}

	}

}
