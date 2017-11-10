package com.example.other;

/**
 * Created by lenovo on 2017/3/22.
 */
public class NullPointerTest {
    public static void main(String[] args) {
        String test = null;
        try {
//            test.charAt(2);
            System.out.println( comulate(null));
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        }


    }

    public  static String comulate(String str) {
        return str;
    }
}