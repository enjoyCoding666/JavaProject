package com.string;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *  一个数如果恰好等于它的因子之和。6=1+2+3.
     *
     * @param wanCount int整型 10000以内
     * @return int整型ArrayList
     */
    public ArrayList<Integer> fun (int wanCount) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if (wanCount==0 || wanCount==1) {
            list.add(wanCount);
            return list;
        }
        for (int i = 1; i <= wanCount; i++) {
            //从1开始一直遍历到 i
            int sum = i;
            for (int j = 1; j < i; j++) {
                if (i%j==0) {
                    sum-=j;
                }
            }
            if(sum==0) {
                list.add(i);
            }
        }
        return list;

    }

}
