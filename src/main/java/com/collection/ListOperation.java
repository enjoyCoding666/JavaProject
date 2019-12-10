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
    public  void ergodic(List<String> list){
          for(String str : list) {
              System.out.println(str);
          }
    }

    /**
     * 通过Iterator遍历
     */
    public void ergodicByIterator(List<String> list){
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
