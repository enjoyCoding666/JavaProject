package com.jvm;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\9 0009 23:10
 * @Description:
 */
public class StringMemoryDemo {
	public static void main(String[] args) {
		strMemoryCompare();
	}


	/**
	 *   String内存模型
	 *
	 */
	public static void strMemoryCompare() {
		//s1是变量，存放在栈里。"HelloWorld"存放在常量池中
		String s1 = "HelloWorld";
		//new String("HelloWorld")是个对象，存放在堆。
		String s2 = new String("HelloWorld");
		String s3 = "HelloWorld";
		String s4 = "World";
		// "HelloWorld" + "World" 在编译时会被优化成"HelloWorld"
		String s5 = "HelloWorld" + "World";
		// 通过加号拼接两个字符串，会在堆上创建的新的对象
		String s6 = s3 + s4;
		System.out.println(s1 == s2);			//false,s1指向常量池中的"HelloWorld",s2指向对象String("HelloWorld")
		System.out.println(s1 == s5);			//true,都指向常量池的"HelloWorld"
		System.out.println(s1 == s6);			//false,因为s3+s4相当于创建了新对象.
		// intern()方法会监测常量池中是否有该字符串的值的字面量，有，返回字符串常量的地址，没有，则新建新建字符串常量并返回内存地址。
		System.out.println(s1 == s6.intern());	//true,都指向常量池中的"HelloWorld"
		System.out.println(s2 == s2.intern());	//false,s2指向对象,s2.intern()指向常量池"HelloWorld"


	}

}
