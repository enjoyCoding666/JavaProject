package com.socket;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * Url用来解析网址。 资源地址。由协议名，资源名，文件名组成。
 */
public class UrlDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
       URL url=new URL("http","www.mldnjava.cn",80,"/curriculum.htm");
	   InputStream input=url.openStream();	
		Scanner scan=new Scanner(input);
		scan.useDelimiter("\n");
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
		
	}

}
