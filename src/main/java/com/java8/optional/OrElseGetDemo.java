package com.java8.optional;

import java.util.Optional;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\7 0007 16:58
 * @Description:
 *
 *  参考资料：https://blog.csdn.net/weixin_30437337/article/details/95443798
 */
public class OrElseGetDemo {

	/**
	 * 如果functionA()返回非null,最终结果是functionA(),然而functionB()这个方法也被执行了。
	 * 如果functionB()中还有插入数据库或者RPC这种操作，问题就大了。
	 * orElse(T)无论前面Optional容器是null还是non-null，都会执行orElse里的方法，orElseGet(Supplier)并不会，
	 * 在T无异常抛出的情况下，Optional使用orElse或者orElseGet的返回结果都是一样的。
	 * 
	 * Optional的orElse(T)若方法不是纯计算型的，有与数据库交互或者远程调用的，都应该使用orElseGet()!!
	 *
	 * @param args
	 */
	public static void main(final String... args) {
		//orElse()无论前面Optional容器是null还是non-null，都会执行orElse里的方法，orElseGet()并不会。
		System.out.println(Optional.ofNullable(functionA()).orElse(functionB()));
		//以下代码相当于：
//		if (functionA() == null) {
//			functionB();
//		}
		System.out.println(Optional.ofNullable(functionA()).orElseGet(OrElseGetDemo::functionB));

	}


	public static String functionB() {
		System.out.println("functionB()...");
		return "B";
	}

	public static String functionA() {
		System.out.println("functionA()");
//		return "A";
		return null;
	}

}
