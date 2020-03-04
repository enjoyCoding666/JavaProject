package com.bean;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\20 0020 20:42
 * @Description:
 */
public class Worker {
    private String id;

    private Integer age;

    private String name;

    public Worker(String id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
