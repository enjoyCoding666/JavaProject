package com.enumdemo.pay;

import com.enumdemo.pay.service.Alipay;
import com.enumdemo.pay.service.EbankPay;
import com.enumdemo.pay.service.PayService;
import com.enumdemo.pay.service.WechatPay;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\13 0013 21:14
 * @Description:
 * 详情参见： https://blog.csdn.net/u012557814/article/details/81671928
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String payType="1";
//        String payType = "ALIPAY";
//        String payType  = "2";
//        String payType  = "3";


//        if("1".equals(payType)) {
//            PayService pay=new Alipay();
//        } else if("2".equals(payType)) {
//            PayService pay=new WechatPay();
//        } else if ("3".equals(payType)) {
//            PayService pay=new EbankPay();
//        }
        //以上代码存在过多的if else判断，可以通过策略模式简化。
        PayService strategy = PayStrategy.getPayStrategy(payType);
        strategy.pay(12);

    }

}
