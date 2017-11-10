package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="1983-07-27";
		String regex="\\d{4}-\\d{2}-\\d{2}";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(str);
		if(m.matches())  {
			System.out.println(str+"日期格式合法");
		}else {
			System.out.println(str+"日期格式不合法");
		}


	}

}
