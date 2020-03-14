package com.string;

import org.apache.commons.lang.StringUtils;

public class EqualsTest {
	public static void main(String args[]) {
		String str1="abc1";
		String str2="AbC1";
		String str3="ABC1";
		System.out.println("不区分大小写，比较结果如下：");
		if(str1.toUpperCase().equals(str2.toUpperCase())){
			System.out.println(str1+"等于"+str2);
		}
		if(str3.toUpperCase().equals(str2.toUpperCase())){
			System.out.println(str3+"等于"+str2);
		}
		if(str1.toUpperCase().equals(str3.toUpperCase())){
			System.out.println(str1+"等于"+str3);
		}
		//使用StringUtils.equalsIgnoreCase比较大小，既不会空指针，也可以忽略大小写。
		if (StringUtils.equalsIgnoreCase(str1, str2)) {
			System.out.println("str1等于str2");
		}
	}
}
