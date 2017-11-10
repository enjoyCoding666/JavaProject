package com.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        File file=new File("E:\\文件输入.txt");
        InputStream is=new FileInputStream(file);
        byte[] b=new byte[1024];
        int len=is.read(b);
        is.close();
        System.out.println("文件内容为：\n"+new String(b,0,len));
	}

}
