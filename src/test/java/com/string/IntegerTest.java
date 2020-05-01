package com.string;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\30 0030 22:49
 * @Description:
 */
public class IntegerTest {
	public static void main(String[] args) {
//		objectToString();
//		nullTest();
//		strToInteger();
	}

	public static void nullTest() {
//		Object obj=null;
		Object object="123";
		String str= (object == null) ? null : object.toString();
		System.out.println(str);
	}

	public static void objectToString() {
		Object object=null;
//		String str = ObjectUtils.toString(object);
		String str = ObjectUtils.toString(object,null);
		System.out.println("值为："+str);
	}

	public static void strToInteger() {
		String str="abc";
		//str不为数字时，设置默认值为 0
		int num = NumberUtils.toInt(str);
		//str不为数字时，设置默认值为其他值
		int defaultNum=NumberUtils.toInt(str,123);
	}

	public void integerValueOfDemo() {
		String str=null;
		Integer value = Integer.valueOf(str);
		System.out.println(value);
	}
}
