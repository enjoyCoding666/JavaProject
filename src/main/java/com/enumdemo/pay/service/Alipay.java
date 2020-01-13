package com.enumdemo.pay.service;

/**
 * @Author: EnjoyCoding
 * @Date: 20:51 2020\1\13 0013
 * @Description:
 */
public class Alipay implements PayService {

    public void pay(double total) {
        System.out.println("pay with alipay: " + total);
    }

}
