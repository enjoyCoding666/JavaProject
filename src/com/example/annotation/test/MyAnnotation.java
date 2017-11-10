package com.example.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    public String name();
    public String job() default "programer";
}
