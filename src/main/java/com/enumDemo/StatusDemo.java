package com.enumDemo;


public class StatusDemo {
    public static void main(String[] args) {
        int number=9;
        String status=null;
        if(number== StatusEnum.Success.getNumber()) {
            status= StatusEnum.Success.getStatus();
        }
        System.out.println(number+"对应的状态为:"+status);
    }


}
