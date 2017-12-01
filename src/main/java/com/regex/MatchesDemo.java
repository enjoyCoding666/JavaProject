package com.regex;

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
        	  String[] splitStr=dateStr.split("-");
        	  date=splitStr[0]+"0"+splitStr[1];
          }
		if(dateStr.matches(regex2)){
      	  String[] splitStr=dateStr.split("-");
    	  date=splitStr[0]+splitStr[1];
		}

	}

}
