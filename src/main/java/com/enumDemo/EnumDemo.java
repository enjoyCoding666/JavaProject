package com.enumDemo;

/**
 * Created by lenovo on  十二月
 */
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(Color.WHITE );
        System.out.println(Color.BLACK);

        for(ColorNumber colorNumber : ColorNumber.values()) {
            System.out.println(colorNumber.getColor());
            System.out.println(colorNumber.getNumber());
        }
    }
}
