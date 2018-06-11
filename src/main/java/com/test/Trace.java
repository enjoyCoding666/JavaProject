package com.test;

/**
 * Created by lenovo on  四月
 */
public class Trace {
    public  String splitString(String text,String str1,String str2){
        String value= text.split(str1)[1].split(str2)[0];
        return value;
    }

    public String getCurrectDate(String date){
        return  date.split("\\.")[0];
    }


}
