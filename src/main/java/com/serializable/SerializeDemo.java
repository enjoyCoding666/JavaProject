package com.serializable;

import java.io.*;

/**
 * 序列化，然后导出数据，之后可以通过反序列化来获得数据
 * 如果属性中添加了transient,那么无法序列化，数据无法导出
 * 为什么要用ObjectOutputStream呢？
 */
public class SerializeDemo {
    public static void main(String[] args) throws IOException {
        Employee employee=new Employee("lin",25,"male","深圳龙岗");
        String fileName="D:\\employee.ser";
        FileOutputStream fos=new FileOutputStream(fileName);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(employee);
        oos.close();
        fos.close();
        System.out.println("序列化后的数据保存在"+fileName);

    }
}
