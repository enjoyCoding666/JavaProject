package com.date;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String args[]){
		Date date1=new Date();
		long currentTime = System.currentTimeMillis();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");

		Date date2 = new Date(currentTime);

		System.out.println(date1);
		System.out.println(formatter.format(date2));



	}

	public void dateToString(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(date);
		System.out.println(date+"转化为字符串是："+str);
	}


	public void stringToDate() {
		//试着用SimpleDateFormat的parse方法将字符串转化为date类型
		//MM必须大写。。区分月份和时间
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str="2016-5-11 11:06:59";
		Date date=null;
		try{
			/*Date类型的parse方法已经过时了，不可用.一般用SimpleDateFormat的parse */
			date=dateFormat.parse(str);
			System.out.println("今天的日期是："+date);
		}catch(ParseException e) {
			e.printStackTrace();
		}
	}

	public void stringToDate2() {
		String str="2016-07-21 15:41:52";
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
			System.out.println(DateFormat.getDateInstance().format(date));
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(date));
			System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date));
			System.out.println(new SimpleDateFormat("yyyy/MM/dd HH/mm/ss").format(date));
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
