package com.jvm.staticdemo;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\11 0011 20:30
 * @Description:
 */
public class Father {
	static {
		System.out.println("Father static");
	}

	public Father() {
		System.out.println("Father Construct");
	}
}
