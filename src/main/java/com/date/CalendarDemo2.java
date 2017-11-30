package com.date;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo2 {
	public static void main(String args[]){
		Calendar calenda=Calendar.getInstance();
		int year=calenda.get(Calendar.YEAR);
		System.out.println("请输入你的生日年份：");

		Scanner sc=new Scanner(System.in);
		int birth=sc.nextInt();    //没有对输入的数据进行校验。。程序不够健壮

		System.out.println("你现在的年龄是："+(year-birth));

	}
}
