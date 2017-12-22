package com.enumDemo;

/**
 * Created by lenovo on  十二月
 */
public enum ColorNumber {
    RED("红色",1) , WHITE("白色",2) ,BLUE("蓝色",4) ,BLACK("黑色",5) ;

    private String color;
    private int number;

    ColorNumber(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
