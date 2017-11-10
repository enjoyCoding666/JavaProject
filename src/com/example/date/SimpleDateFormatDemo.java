package com.example.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String args[]){
    	//试着用SimpleDateFormat的parse方法将字符串转化为date类型
    	DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //MM必须大写。。区分月份和时间
    	String str="2016-5-11 11:06:59";
    	Date date=null;
    	try{
    		date=dateFormat.parse(str);     /*Date类型的parse方法已经过时了，不可用.一般用SimpleDateFormat的parse */
    		System.out.println("今天的日期是："+date);
    	}catch(ParseException e) {
    		e.printStackTrace();
    	}
    	
    }
}
