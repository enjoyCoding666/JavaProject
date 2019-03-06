package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaSort {
    public static void main(String[] args) {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Richard Gasquet", "John Isner"};

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);


        // 1.3 也可以采用如下形式:
//        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));


    }
}
