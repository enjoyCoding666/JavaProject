package com.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarDemo {
    public static void main(String args[]){
        Calendar calenda=new GregorianCalendar();   //GregorianCalendar是日历的子类。
        System.out.println("年："+calenda.get(Calendar.YEAR));   //Calendar.YEAR是常量。意指年


    }
}
