package com.test;

import com.alibaba.druid.sql.visitor.functions.Char;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log
public class Test {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        StringBuilder stars=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        while (in.hasNext()) {
            String input=in.next();
            for(char c:input.toCharArray()){
                if ('*'==c){
                    stars.append("*");
                }else {
                    sb.append(c);
                }
            }
        }
        System.out.println(stars.toString()+sb.toString());
    }
}
