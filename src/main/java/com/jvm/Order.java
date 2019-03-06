package com.jvm;

/**
 *   考察类加载机制、初始化的顺序。
 */
public class Order {

    private static Order order=new Order();

    private  static  int a;
    private  static int b=0;


    public Order(){
        a++;
        b++;
    }

    public  static Order getOrder(){
        return  order;
    }

    public static void main(String[] args) {
        Order order=Order.getOrder();
        System.out.println(order.a);
        System.out.println(order.b);
    }
}
