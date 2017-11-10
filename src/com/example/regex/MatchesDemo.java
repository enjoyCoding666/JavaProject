package com.example.regex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MatchesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//          String dateStr="2016-06-18 01:09:32";
//          String dateStr="2016-6-18 02:09:32";
          String dateStr="2016-6-8 03:09:32";
          String regex1="\\d{4}-\\d{1}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}";
          String regex2="\\d{4}-\\d{2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}";
          String date=null;
		if(dateStr.matches(regex1)){
        	  System.out.println(dateStr+"是日期格式");
        	  String[] splitStr=dateStr.split("-");
        	  date=splitStr[0]+"0"+splitStr[1];
        	  System.out.println("提取得到的日期是："+date);
          }
		if(dateStr.matches(regex2)){
      	  System.out.println(dateStr+"是日期格式");
      	  String[] splitStr=dateStr.split("-");
    	  date=splitStr[0]+splitStr[1];
    	  System.out.println("提取得到的日期是："+date);
		}  

	}

}
