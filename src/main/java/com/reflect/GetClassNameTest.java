package com.reflect;

/**
 * Created by lenovo on 2017/6/23.
 */
public class GetClassNameTest {
    public static void main(String[] args) {
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println("class:"+clazz+"\nmethod:"+method);
    }
}
