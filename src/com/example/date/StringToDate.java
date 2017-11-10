package com.example.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
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