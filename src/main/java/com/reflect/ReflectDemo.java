package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/6/23.
 */
public class ReflectDemo {
    /**
     * 通过Class实例化
     * @return
     * @throws Exception
     */
    public  void initByReflect() throws  Exception{
        //获取class，并实例化
        Class clazz=Class.forName("com.reflect.Car");
        Car car=(Car)clazz.newInstance();
        //也可以通过以下代码获取Class
//        Class carClass=new Car().getClass();
    }


    public  void setPropertyByField( ) throws  Exception{
        Class carClass=  Class.forName("com.reflect.Car");
        Car car=(Car)carClass.newInstance();
        Field field=carClass.getDeclaredField("color");
        //将私有化的属性设为可访问
        field.setAccessible(true);
        field.set(car,"黑色");             //相当于car.setCalor("黑色);
        System.out.println("通过反射获取属性："+ car.getColor());
    }


   public  Object getPropertyByField() throws  Exception{
        Car car=new Car("bmw","白色",350);
        Field field=car.getClass().getDeclaredField("color");
        //将私有化的属性设为可访问
       field.setAccessible(true);
       Object value=field.get(car);
       System.out.println(value);
        return value;
   }

    /**
     * 通过反射调用方法
     */
    public  static void setterByReflect() throws  Exception{
            Class<?> carClass=Class.forName("com.reflect.Car");
            Car car=(Car)carClass.newInstance();
            Method method=carClass.getMethod("setColor", String.class);
            method.invoke(car,"黑色");
            System.out.println("通过反射调用方法的结果："+car.getColor());
    }


    /**
     * 通过构造器初始化
     * @return
     * @throws Exception
     */
    public   void initByDefaultConst() throws Exception {
        //通过类加载器获取Class
        ClassLoader  loader=Thread.currentThread().getContextClassLoader();
        Class<?> clazz=loader.loadClass("com.reflect.Car");
        //获取类的所有构造器并通过它实例化，要注意在Car类中构造器的顺序
        Constructor<?> constructor[]=clazz.getConstructors();
        Car car=(Car) constructor[0].newInstance("BMW","黑色",200);
        car.introduce();

    }

    /**
     * 获取类名、方法名等信息
     */
    public  void getClassName(){
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println("class:"+clazz+"\nmethod:"+method);
    }

}
