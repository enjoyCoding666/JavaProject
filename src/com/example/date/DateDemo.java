package com.example.date;

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
}
