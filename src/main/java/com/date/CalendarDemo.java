package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\1 0001 16:17
 * @Description:
 */
public class CalendarDemo {

	public static void setCalendarTime() throws ParseException {
		String dateStr="2018-07-07 07:08:11";
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = simpleDateFormat.parse(dateStr);
		Calendar calendar = Calendar.getInstance();
		//通过calendar设置时间
		calendar.setTime(date);
		//获取calendar对应的时间
		Date time = calendar.getTime();
		System.out.println(time);
	}

	public static void setCalendarMonthDay() {
		Calendar calendar = Calendar.getInstance();
		//通过Calendar设置年月日
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.DAY_OF_MONTH, 7);
		calendar.set(Calendar.YEAR, 2018);
		calendar.set(Calendar.HOUR_OF_DAY,19);
		//通过Calendar获取时间，年月日
		Date date = calendar.getTime();
		int year = calendar.get(Calendar.YEAR);
		//Calendar的月份是从0开始计算的，所以要加一才是真实的月份
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(date);
		System.out.println("year:" + year);
		System.out.println("month:" + month);
		System.out.println("day:" + day);
		System.out.println("hour:" + hour);
	}
}
