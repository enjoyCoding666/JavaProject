package com.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseTest {
	public static void main(String[] args) {

		//创建给定模式和默认语言环境的DateFormat对象

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String stringDate = "2016-5-10 11:50:20"; //定义字符串类型的日期/时间

		System.out.println("字符串类型的日期/时间如下：");

		System.out.println(stringDate);   //输出字符串类型的日期/时间

		Date date = null;      //定义Date对象

		try {

			date = df.parse(stringDate);   //将字符串类型的日期/时间解析为Date类型

		} catch (ParseException e) {

			e.printStackTrace();

		}

		System.out.println("解析后生成的Date对象表示的日期/时间如下：");

		System.out.println(date);

		//输出Date对象表示的日期/时间

	}



}
