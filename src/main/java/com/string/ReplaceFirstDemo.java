package com.string;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\9 0009 23:16
 * @Description:
 */
public class ReplaceFirstDemo {

	public static void main(String[] args) {
		String test="a b c defg ";
		int count = replaceSpaceCount(test);
		System.out.println(count);
	}

	public static int replaceSpaceCount(String str) {
		if (str == null) {
			return 0;
		}
		int count=0;
		while (str.contains(" ")) {
			str = str.replaceFirst(" ", "");
			count++;
		}
		System.out.println(str);
		return count;
	}


}
