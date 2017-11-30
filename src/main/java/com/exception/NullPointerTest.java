package com.exception;

/**
 * Created by lenovo on 2017/3/22.
 */
public class NullPointerTest {
    public static void main(String[] args) {
        String test = null;
        try {
            System.out.println( comulate(null));
        } catch (NullPointerException e) {
        }


    }

    public  static String comulate(String str) {
        return str;
    }
}