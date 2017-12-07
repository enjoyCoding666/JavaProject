package com.exception;


/**
 * Created by lenovo on  十二月
 */
public class MyException extends  Exception {
    private  static  final  long serialVersionUID=1L;
    /**
     * 错误编码
     */
     private String errorCode;
    /**
     * 消息是否为属性文件中的Key
     */
    private boolean propertiesKey=true;

    /**
     * 构造一个基本异常
     * @param message  信息描述
     */
    public MyException(String message){
        super(message);
    }

     public MyException(String errorCode,String message,boolean propertiesKey){
        super(message);
        this.setErrorCode(errorCode);
        this.setPropertiesKey(propertiesKey);
     }




    public  MyException(String errorCode,String message){

        this(errorCode,message,true);
    }

    /**
     *
     * @param message  信息描述
     * @param cause    根异常类(可以存入任何异常)
     */
    public MyException(String message,Throwable cause){
        super(message,cause);
    }

    public MyException(String message,String errorCode,Boolean propertiesKey,Throwable cause) {
        super(message,cause);
        this.setPropertiesKey(propertiesKey);
        this.setErrorCode(errorCode);
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}
