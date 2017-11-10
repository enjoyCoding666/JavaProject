package com.example.exception;

/**
 * Created by lenovo on 2017/8/22.
 */
public class CatchExceptionTest {
    public static void main(String[] args) {
        try{
            System.out.println("执行rty模块代码");
            String exception=null;
            exception.toUpperCase();

        }catch (Exception e) {
            System.out.println("catch异常代码");
            e.printStackTrace();
        }
        System.out.println("程序结束");
    }
}
