package com.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/3/23.
 */
public class WordsAmount {
    public static void main(String[] args) {
        String str="apple 1 banana  2pear 23 banana pear pear";
        Map wordsMap=countEachWorld(str);
        printMap( wordsMap );      ;
    }
    //计算字符串中每一个单词出现的个数
    public static Map countWords(String str){
        if(str==null || str.isEmpty() ) {
            System.out.println("字符串为空，无法分隔出单词");
            return null;
        }
       String[] splitResult=str.split("[^A-Za-z]");
       Map<String,Integer> map=new ConcurrentHashMap<String,Integer>();
       map.put(splitResult[0].toLowerCase(),0);
       for(String word:splitResult) {
           Iterator< Map.Entry<String,Integer> > iterator=map.entrySet().iterator();
           String wordLowerCase=word.toLowerCase();
           int n=0;
           while (iterator.hasNext()) {
               Map.Entry<String, Integer> entry = iterator.next();
               if(  wordLowerCase.equals(entry.getKey() ) ){
                   map.put(wordLowerCase,entry.getValue()+1);
                   break;
               }
               n++;
           }
           //如果单词和map里所有的key都不同，就把单词作为新的key加入到map里
          if(n==map.size() && !wordLowerCase.isEmpty()) {
               map.put(wordLowerCase,1);
          }
       }
        return  map;
    }

    //遍历并打印map
    public  static void printMap(Map<String,Integer> map) {

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

    }



    /**
     * 统计文本每个单词的个数
     * @param str  字符串
     * @return
     */
    public static    Map<String ,Integer> countEachWorld(String str){
        Matcher m= Pattern.compile("[A-Za-z]+").matcher(str);
        String matcheStr=null;
        Map<String ,Integer> map=new LinkedHashMap<String ,Integer>();
        Integer count=0;
        while(m.find()){
            matcheStr=m.group().toLowerCase();
            count=map.get(matcheStr);
            map.put(matcheStr, count!=null?count+1:1);
        }
        return map;
    }
}
