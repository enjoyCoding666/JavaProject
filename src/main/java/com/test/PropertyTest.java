package com.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTest {
    public static void main(String[] args) throws IOException {
        Properties    props = new Properties();
        String PATH="G:\\Java框架Demo\\JavaDemo\\src\\main\\resource\\jdbc.properties";
        InputStream in = new BufferedInputStream(new FileInputStream( PATH ));
        props.load(in);
        String value=props.getProperty("user");
        System.out.println(PATH+"路径下的值为"+value);
    }
}
