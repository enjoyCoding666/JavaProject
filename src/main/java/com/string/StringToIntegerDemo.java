package com.string;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\30 0030 23:58
 * @Description:
 */
public class StringToIntegerDemo {


	public static void main(String[] args) {
//		objectToString();
//		nullToEmpty();
//		strToInteger();
//		integerValueOfDemo();
	}

	public static void nullToEmpty() {
		Object object=null;
		String str = ObjectUtils.toString(object);
//		String str = ObjectUtils.toString(object,null);
		System.out.println("值为："+str);
	}

	public static void strToInteger() {
		String str="abc";
		//str不为数字时，设置默认值为 0
		int num = NumberUtils.toInt(str);
		//str不为数字时，设置默认值为其他值
		int defaultNum=NumberUtils.toInt(str,123);
	}

	public static void integerValueOfDemo() {
		String str="123";
//		String str="";
		//str为非数字字符串时，报错： NumberFormatException:""
		Integer value = Integer.valueOf(str);
		System.out.println(value);
	}

	public static void intToInteger() {
		int value=0;
		Integer val=(Integer)value;
	}
}
