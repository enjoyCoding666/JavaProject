package com.base;

/**
 * @Author: lenovo
 * @Date: 2018/12/3 11:27
 * @Description:
 * 无符号数a的左移相当于将该数用二进制表示，左移n位就是把最高位n位移出，低位添加n个0的操作，左移操作相当于将该数乘以2^n次方。
 * 右移操作相当于将该数除以2^n次方。
 */
public class BitOperation {
    public static void main(String[] args) {
        System.out.println("1左移4位结果为："+(1<<4) );

        System.out.println("1左移4位结果为："+(16>>4) );

    }
}
