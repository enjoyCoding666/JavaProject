package com.jvm.staticdemo;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\11 0011 20:33
 * @Description:
 */
public class Son extends Father {
	/**
	 *
	 */
	static {
		System.out.println("Son static");
	}

	/**
	 * java中执行子类的构造方法时，会先执行一次父类的构造方法。
	 *
	 */
	public Son() {
		System.out.println("Son Construct");
	}

	/**
	 *
	 * 父类的静态代码块和子类的静态代码块会先执行。
	 * 然后再执行他们各自的构造方法。
	 * @param args
	 */
	public static void main(String[] args) {
		new Father();
		new Son();
	}
}
