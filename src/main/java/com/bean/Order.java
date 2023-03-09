package com.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private String weight;

    private double price;

    private int age ;

    private String dateStr;

    private Date createTime;

}
