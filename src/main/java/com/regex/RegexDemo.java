package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String args[]){
		String str="1983-07-27";
		String pat="\\d{4}-\\d{2}-\\d{2}";
		Pattern p=Pattern.compile(pat);   //先声明模式
		Matcher m=p.matcher(str);    //接着再匹配
		if(m.matches())  {
			System.out.println("日期格式各法");
		}else {
			System.out.println("日期格式不合法");

		}


	}
}
