package com.example.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
//使用OutputStreamDemo，将数据写入文件里面.
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
        File file=new File("E:\\createNewFile\\文件输入.txt");
        OutputStream os=new FileOutputStream(file,true);
        String str="Work hard!!\n";
        byte[] b=str.getBytes();
        os.write(b);
        os.close();
        System.out.println("成功写入数据");
	}

}
