package com.enumdemo.pay;

/**
 * @Auther: Administrator
 * @Date: 2020\1\13 0013 20:38
 * @Description:
 */
public enum PayEnum {
    /**
     *  枚举常量对应的className，根据项目类的路径设置
     *
     */
    ALIPAY("1","com.enumdemo.pay.service.Alipay"),
    WECHATPAY("2","com.enumdemo.pay.service.WechatPay"),
    EBANKPAY("3","com.enumdemo.pay.service.EbankPay")

    ;

    private String payClassName;
    private String payType;



    PayEnum(String payType, String payClassName) {
        this.setPayClassName(payClassName);
        this.setPayType(payType);
    }

    public String getPayClassName() {
        return payClassName;
    }

    public void setPayClassName(String payClassName) {
        this.payClassName = payClassName;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayType() {
        return payType;
    }

    /**
     * 根据支付类型，得到对应的支付类的路径
     *
     * @param payType
     * @return
     */
    public static String getPayClassNameByType(String payType) {
        for (PayEnum payEnum : PayEnum.values()) {
            if (payEnum.getPayType().equals(payType)) {
                return payEnum.getPayClassName();
            }
        }
        return null;
    }

}