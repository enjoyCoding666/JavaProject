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


	public static void main(String[] args) {

//		timeToString();

//		stringToTime();

//		localDateTest();

		monthDiff();
	}

	private static void timeToString() {
		// 日期时间转字符串
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//当前时间
		LocalDateTime now = LocalDateTime.now();
		String nowText = now.format(formatter);
		System.out.println("nowText为：" + nowText);
	}

	private static void stringToTime() {
		// 字符串转日期时间
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datetimeText = "2020-04-01 23:59:59";
		LocalDateTime localDateTime= LocalDateTime.parse(datetimeText, formatter);
		// LocalDateTime的toString()方法，在日期和时间中间加入了"T"字符串
		System.out.println(localDateTime);
	}

	private static void localDateTest() {
		LocalDate date = LocalDate.of(2000, 1, 1);
		System.out.println("构造的日期为：" + date);
	}

	private static void monthDiff(){
		LocalDate date1 = LocalDate.of(2019, 1, 15);
		LocalDate date2 = LocalDate.of(2019, 3, 10);
		Period period = Period.between(date1, date2);
		System.out.println("相差的年数为"+period.getYears() + "，相差的月数为：" + period.getMonths() +
				"，相差的天数为：" + period.getDays());
	}

}
