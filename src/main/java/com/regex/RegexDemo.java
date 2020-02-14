package com.regex;

/**
 * @Author: lenovo
 * @Date: 2020/2/2 21:46
 * @Description:
 *
 * 详情参见：https://www.cnblogs.com/expiator/p/12250598.html
 */
public class RegexDemo {

    public static void regex1(){
        String str="abcdddabc";
        String regex=".*d+.*";
        if (str.matches(regex)){
            System.out.println(true);
        }
    }

    public static void regex2(){
        String str="abcdefg";
        String regex=".*efg";
        if (str.matches(regex)){
            System.out.println(true);
        }
    }


    public static void regex3(){
        String str="a";
        String regex="\\w";
        if (str.matches(regex)) {
            System.out.println(true);
        }
    }

    public static void regex4(){
        String str="abdf1459";
        String regex="[a-z]{4}[1-9]{4}";
        if (str.matches(regex)) {
            System.out.println(true);
        }
    }


    public static void regex6(){
        String str="catdog";
        String regex="^cat$";
        String regex2="^cat.*";
        String regex3=".*dog$";
        boolean isMatch1=str.matches(regex);
        boolean isMatch2=str.matches(regex2);
        boolean isMatch3=str.matches(regex3);
        System.out.println(isMatch1+","+isMatch2+","+isMatch3);
    }

}
