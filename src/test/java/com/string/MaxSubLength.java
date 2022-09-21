package com.string;

import java.util.*;
public class MaxSubLength {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int result = getMaxSubLength(in.next());
        System.out.println(result);
    }

    /**
     * 最长不重复子串的长度。abcdcad
     */
    public static int getMaxSubLength(String word) {
        if (word==null) {
            return 0;
        }
        int max=0;
        int left=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<word.length();i++) {
            //如果重复，重新算下标
            if (map.containsKey(word.charAt(i))) {
                left = Math.max(left, map.get(word.charAt(i))+1);
            }
            map.put(word.charAt(i), i);
            //最大长度
            max = Math.max(max, i-left+1);

        }
        return max;


    }

}

