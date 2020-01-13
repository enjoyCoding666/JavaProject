package com.enumdemo.pay;

import com.enumdemo.pay.service.PayService;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\13 0013 20:40
 * @Description:
 *
 */
public class PayStrategy {

    public static PayService getPayStrategy(String payType) throws Exception {
        //valueOf()方法，可以通过枚举常量的名称(比如ALIPAY)，得到枚举常量。再通过枚举常量得到支付类的路径
//        String payClassName = PayEnum.valueOf(payType).getPayClassName();
        //直接根据支付类型，获取对应的支付类的路径
        String payClassName= PayEnum.getPayClassNameByType(payType);
        //根据类名进行反射，生成对象
        return (PayService) Class.forName(payClassName).newInstance();
    }

}