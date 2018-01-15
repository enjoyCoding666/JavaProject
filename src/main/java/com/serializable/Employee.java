package com.serializable;

import java.io.Serializable;

/**
 * 实现了接口Serializable，就可以实现序列化
 * 关键字transient，可以使属性无法序列化，保护数据。
 */
public class Employee implements Serializable {

    private String name;
    private int age;
    private  String sex;
    private transient String adress;

    public Employee(String name, int age, String sex, String adress) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
