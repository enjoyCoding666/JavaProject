package com.example.io;

import java.io.File;
import java.io.FileReader;

public class FileReadDemo {

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        File file =new File("E:\\文件输入.txt");
        FileReader fr=new FileReader(file);
        char[] c=new char[1024];
        int len=fr.read(c);
        fr.close();
        System.out.println("文件内容为:"+new String(c,0,len));
    }

}
