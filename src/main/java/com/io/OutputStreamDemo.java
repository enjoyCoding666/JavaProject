package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamDemo {
    /**
     * 使用OutputStreamDemo，将数据写入文件里面.
     * @param args
     * @throws Exception IOException
     */
	public static void main(String[] args)  throws Exception{
        // TODO Auto-generated method stub
        File file=new File("E:\\文件输入.txt");
        OutputStream fos=new FileOutputStream(file,true);
        String str="Work hard!!\n";
        byte[] bytes=str.getBytes();
        fos.write(bytes);
        fos.close();
        System.out.println("成功写入数据");
    }

}
