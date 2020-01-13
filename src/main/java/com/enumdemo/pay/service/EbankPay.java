package com.enumdemo.pay.service;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\13 0013 20:55
 * @Description:
 */
public class EbankPay implements PayService {

    public void pay(double total) {
        System.out.println("pay with ebankPay: " + total);
    }

}
