package com.collection;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lenovo on  一月
 */
public class ListOperation {
    /**
     * 遍历List
     */
    public static void ergodic(List<?> list){
          for(Object o: list) {
              System.out.println(o);
          }
    }

    /**
     * 通过Iterator遍历
     */
    public static void ergodicByIterator(List<String> list){
        //创建集合的迭代器
        Iterator<String> iterator=list.iterator();
        //hasNext()检验是否还有下一个.
        //用迭代器遍历list
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    public List arraysToList(String[] strArray){
        return Arrays.asList(strArray);
    }

    public Object[] listToArrays(List<String> list){
       return list.toArray();
    }

}
