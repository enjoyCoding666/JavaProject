package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lenovo on 2017/6/23.
 */
public class CarReflect {
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
     *  设置某个对象的公共属性
     * @param object
     * @param fieldName
     * @return
     * @throws Exception
     */
    public static void setPropertyByField(Object object,String fieldName,Object value) throws  Exception{
        Field field=object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object,value);
        System.out.println(field.get(object) );
    }

    /**
     *
     * @param object
     * @param fieldName
     * @return
     * @throws Exception
     */
   public static Object getPropertyByField(Object object,String fieldName) throws  Exception{
        Field field=object.getClass().getDeclaredField(fieldName);
        Object value=field.get(object);
        return value;
   }

    /**
     * 通过反射设置方法
     * @param object         Class实例化的对象
     * @param methodName    要操作的方法名
     * @param value          设置的值
     * @param classType     Class的类型
     */
    public static  void setterByReflect(Object object,String methodName,Object value,Class<?> classType){
         try {
             Method method=object.getClass().getMethod(methodName,classType);
             method.invoke(object,value);
         }catch (Exception e){
             e.printStackTrace();
         }
    }

    /**
     * 通过反射调用方法
     * @param object
     * @param methodName
     */
    public static void getterByReflect(Object object,String methodName){
           try {
              Method method=object.getClass().getMethod(methodName);
              method.invoke(object);
           }catch (Exception e){
               e.printStackTrace();
           }
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
        //通过反射方法调用类中的方法，设置属性
        setterByReflect(car,"setBrand","雷克萨斯",String.class);
        setterByReflect(car,"setColor","黑色",String.class);
        setterByReflect(car,"setMaxSpeed",120,int.class);
        return car;

    }

    /**
     * 获取类名、方法名等信息
     */
    public  void getClassName(){
        String clazz = Thread.currentThread() .getStackTrace()[1].getClassName();
        String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
        System.out.println("class:"+clazz+"\nmethod:"+method);
    }

    public static void main(String[] args) throws Exception {
        Car car=  initByDefaultConst();
        car.introduce();
    }
}
