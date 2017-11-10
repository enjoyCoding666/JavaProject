package com.example.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String str= null;
        str=sdf.format(date);
        System.out.println(date+"转化为字符串是："+str);
    }

}
