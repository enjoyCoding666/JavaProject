package com.example.object;

/**
 * Created by lenovo on
 */
public class ObjectEquals {
    public static void main(String[] args) {
        Person person1=new Person("lin",25);
        Person person2=new Person("lin",25);
        System.out.println("通过==比较对象:");
        if(person1==person2) {
            System.out.println("person1和person2是同一个人");
        }else {
            System.out.println("person1和person2不是同一个人");
        }
        System.out.println("通过重写equals()和hashCode()比较对象:");
        if(person1.equals(person2)) {
            System.out.println("person1和person2是同一个人");
        }else {
            System.out.println("person1和person2不是同一个人");
        }
    }


}
