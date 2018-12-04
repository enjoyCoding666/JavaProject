package com.string;


public class CharInString {
    public static void main(String[] args) {
          String words="HelloWorld";
          ergodicString(words);
    }


    /**
     * 遍历字符串。
     * @param words
     */
    public static void ergodicString(String words){
        for(char c : words.toCharArray()) {
            System.out.println(c);
        }
    }

}
