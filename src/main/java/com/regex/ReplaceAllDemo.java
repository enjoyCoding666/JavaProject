package com.regex;

/**
 * @Auther: Administrator
 * @Date: 2019\12\8 0008 16:33
 * @Description:
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String test="123abc45def";
        System.out.println(test.replaceAll("\\d+",""));
    }
}
