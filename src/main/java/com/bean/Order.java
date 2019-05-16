package com.bean;

import lombok.extern.java.Log;

/**
 * Created by lenovo on  十一月
 */

public class Order {
    private String phoneNumber;
    private String doneCode;
    private String date;

    public Order(String phoneNumber, String doneCode, String date) {
        this.phoneNumber = phoneNumber;
        this.doneCode = doneCode;
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDoneCode() {
        return doneCode;
    }

    public void setDoneCode(String doneCode) {
        this.doneCode = doneCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        if (!phoneNumber.equals(order.phoneNumber)) {
            return false;
        }
        if (!doneCode.equals(order.doneCode)) {
            return false;
        }
        return date.equals(order.date);
    }

    @Override
    public int hashCode() {
        int result = phoneNumber.hashCode();
        result = 31 * result + doneCode.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }
}
