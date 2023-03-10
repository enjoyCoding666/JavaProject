package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Optional;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\1\20 0020 20:42
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private String id;

    private Integer age;

    private String name;

    private Address address;

    public Worker(String id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }


    /**
     * 返回Optional对象。
     * @return
     */
    public Optional<Address> getAddressOptional() {
        return Optional.ofNullable(this.address);
    }



}
