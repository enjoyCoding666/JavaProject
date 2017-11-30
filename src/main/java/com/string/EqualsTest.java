package com.string;

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
	}
}
