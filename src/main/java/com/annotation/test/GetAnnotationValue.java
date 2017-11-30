package com.annotation.test;

/**
    通过反射获取Annotations的值
 */
public class GetAnnotationValue {
    public static void main(String[] args) throws Exception {
        Class<?> c=Class.forName("com.annotation.test.Person");

        if(c.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation=c.getAnnotation(MyAnnotation.class);
            String name=annotation.name();
            String job=annotation.job();
            System.out.println("name:"+name);
            System.out.println("job:"+job);
        }

    }
}
