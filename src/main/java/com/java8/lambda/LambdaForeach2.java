package com.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaForeach2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(x->{
              if(x>2){
                  System.out.println(x);
             }
        });

    }
}
