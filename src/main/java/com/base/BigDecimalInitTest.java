package com.base;

import java.math.BigDecimal;

/**
 * @Auther: Administrator
 * @Date: 2019\9\3 0003 0:24
 * @Description:
 */
public class BigDecimalInitTest {
    public static void main(String[] args) {
        BigDecimal amount1=new BigDecimal("0.06");
        BigDecimal amount2=new BigDecimal(0.06);
        System.out.println(amount1);
        System.out.println(amount2);
    }
}

