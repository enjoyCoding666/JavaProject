package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/6/23.
 */
public class CarReflect {
    /**
     * 获取类名、方法名等信息
     */
    public  void getClassName(){
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println("class:"+clazz+"\nmethod:"+method);
    }


    /**
     * 通过Class实例化
     * @return
     * @throws Exception
     */
    public static void initByReflect() throws  Exception{
        //实例化
        Class clazz=Class.forName("com.reflect.Car");
        Car car=(Car)clazz.newInstance();

    }

    /**
     * 通过构造器初始化
     * @return
     * @throws Exception
     */
    public  static Car initByDefaultConst() throws Exception {
        //通过类加载器获取对象
        ClassLoader  loader=Thread.currentThread().getContextClassLoader();
        Class clazz=loader.loadClass("com.reflect.Car");
        //获取类的默认构造器并通过它实例化
        Constructor constructor=clazz.getDeclaredConstructor(null);
        Car car=(Car)constructor.newInstance();
        //通过反射方法设置属性
        Method setBrand=clazz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"雷克萨斯");
        Method setColor=clazz.getMethod("setColor",String.class);
        setColor.invoke(car,"黑色");
        Method setMaxSpeed=clazz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,120);
        return car;

    }


    public static void main(String[] args) throws Exception {
        Car car=  initByDefaultConst();
        car.introduce();
    }
}
