package com.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaForeach {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(x-> System.out.println(x));
//      也可以使用双冒号::
//      list.forEach(System.out::println);
    }
}
