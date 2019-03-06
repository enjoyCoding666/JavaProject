package com.lambda;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        int sum = list.stream().map( x -> x*x ).reduce( (x,y) -> x + y).get();
        System.out.println(sum);
      
//          传统的代码表现方式如下：
//          List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
//          int sum = 0;
//          for(Integer n : list) {
//              int x = n * n;
//              sum = sum + x;
//          }
//          System.out.println(sum);

    }
}
