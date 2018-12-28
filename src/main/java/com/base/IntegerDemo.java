package com.base;

public class IntegerDemo {
    public static void main(String[] args) {
        //没必要写成 Integer number1=new Integer(15);
        Integer number1=15;
        Integer number2=15;
        int number3=15;

        if(number1==number2) {
            System.out.println("number1和number2相等");
        }
        if(number2==number3) {
            System.out.println("number2和number3相等");
        }

    }
}
