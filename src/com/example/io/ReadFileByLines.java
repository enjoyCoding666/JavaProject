package com.example.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileByLines {
     public static void main(String args[])throws Exception{
//    	 String fileName="E:\\文件处理.txt";   
    	 File file=new File("E:\\文件处理.txt");
    	 BufferedReader reader=new BufferedReader(new FileReader(file));
    	 String lineString;
    	 int line=1;
    	 while((lineString=reader.readLine())!=null){
    		 System.out.println("line"+line+" :"+lineString);
    		 line++;	 
    	 }
    	 reader.close();
     }
}
