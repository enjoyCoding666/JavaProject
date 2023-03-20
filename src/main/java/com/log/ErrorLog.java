package com.log;

import com.java8.completefuture.CompleteFutureDemo;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ErrorLog {

    public static void main(String[] args) {
        String param = "xxx";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(param);
        } catch (Exception e) {
            //打印error日志时，最好能够把参数也打印出来，这样方便排查错误。
            log.error("parse error.str:{}", param, e);
        }
    }
}
