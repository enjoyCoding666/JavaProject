package com.java8.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\15 0015 23:31
 * @Description:
 */
public class LocalDateDemo {


	public  void timeToString() {
		// 日期时间转字符串
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.of(2020, 1, 8, 15, 16, 17);
		String dateTimeStr = dateTime.format(formatter);
		System.out.println("dateTimeStr为：" + dateTime);
	}

	public  void stringToTime() {
		// 字符串转日期时间
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetimeText = "2020-04-01 23:59:59";
		LocalDateTime localDateTime = LocalDateTime.parse(datetimeText, formatter);
		// LocalDateTime的toString()方法，在日期和时间中间加入了"T"字符串
		System.out.println(localDateTime);
	}

	public  void generateLocalDate() {
		LocalDate date = LocalDate.of(2000, 1, 8);
		LocalDateTime dateTime = LocalDateTime.of(2020, 1, 8, 15, 16, 17);
		System.out.println("date：" + date);
		System.out.println("dateTime:" + dateTime);
	}
	
	public  void getLocalDateTimeMonth() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 1, 8, 15, 16, 17);
		int year=dateTime.getYear();
		int month=dateTime.getMonth().getValue();
		int day=dateTime.getDayOfMonth();
		System.out.println("dateTime对应的年份为："+year);
		System.out.println("dateTime对应的年份为："+month);
		System.out.println("dateTime对应的年份为："+day);
	}

	public  void monthDiff() {
		LocalDate date1 = LocalDate.of(2019, 1, 15);
		LocalDate date2 = LocalDate.of(2019, 3, 10);
		Period period = Period.between(date1, date2);
		System.out.println("相差的年数为" + period.getYears() + "，相差的月数为：" + period.getMonths() +
				"，相差的天数为：" + period.getDays());
	}

	public void addMonthDay() {
		LocalDateTime dt = LocalDateTime.of(2020, 1, 26, 20, 30, 59);
		System.out.println(dt);
		// 加5天减3小时:
		LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
		System.out.println(dt2); // 2019-10-31T17:30:59
		// 减1月:
		LocalDateTime dt3 = dt2.minusMonths(1);
		System.out.println(dt3); // 2019-09-30T17:30:59
	}

}
