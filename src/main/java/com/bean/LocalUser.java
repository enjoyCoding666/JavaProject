package com.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalUser {
    private  int id;
    private String userName;
    private  String  password;
    private  int age;


}
