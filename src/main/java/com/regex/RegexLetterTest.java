package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexLetterTest {
	public static void main(String args[]){
		//输入字符串，然后验证是否符合格式
		String str="QQabc4755";
		String pat="\\p{Upper}{2}\\p{Lower}{3}\\d{4}";    //定义验证规则
		Pattern p=Pattern.compile(pat);    //实例化模式类
		Matcher match=p.matcher(str);      //验证字符串内容是否合法
		if(match.matches())  {
			System.out.println("字符串符合格式");
		} else {
			System.out.println("字符串不符合格式");
		}

	}
}
