package com.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lenovo on  一月
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee employee;
        try {
            String fileName="D:\\employee.ser";
            FileInputStream fis=new FileInputStream(fileName);
            ObjectInputStream  oos=new ObjectInputStream(fis);
            employee=(Employee)oos.readObject();
            oos.close();
            fis.close();
        }catch (IOException  | ClassNotFoundException e){
               e.printStackTrace();
               return;
        }
        System.out.println("Name:"+employee.getName());
        System.out.println("age:"+employee.getAge());
        System.out.println("Adress:"+employee.getAdress());
    }
}
