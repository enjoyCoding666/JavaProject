package com.java8.optional;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.bean.Address;
import com.bean.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\5 0005 23:28
 * @Description:
 */
public class OptionalDemo {

	/**
	 * orElse(默认值)，如果Optional<T>封装的对象不存在值，则返回默认值。
	 */
	public static void orElseDemo() {
//		Worker worker1=new Worker("123",18,"lin");
		Worker worker1 = null;
		Worker worker2 = new Worker("456", 28, "chen");
		//如果worker1不为null，则orElse返回worker1,否则返回默认值worker2
		Worker result = Optional.ofNullable(worker1).orElse(worker2);
		//相当于以下代码：
//		if (worker1 != null) {
//			result = worker1;
//		} else {
//			result = worker2;
//		}
		System.out.println(result.getName() + "," + result.getAge());
	}

	/**
	 * orElseGet()，如果Optional<T>封装的对象不存在值，则执行Supplier函数式。
	 * orElseGet(Supplier<? extends T> other)，返回的类型必须和Optional封装的对象类型一致。
	 */
	public static void ofElseGetDemo() {
		String name1 = null;
		String name2 = "lin";
		//orElseGet(Supplier<? extends T> other)，返回的类型必须和Optional封装的对象类型一致。
		String result = Optional.ofNullable(name1).orElseGet(OptionalDemo::supplier);
		System.out.println(result);
	}

	public static String supplier() {
		return "orElseGet(Supplier)";
	}

	/**
	 * of(对象)，如果封装的对象为空，则会报出空指针异常
	 */
	public static void ofDemo() {
//		Worker worker1=new Worker("123",18,"lin");
		Worker worker1 = null;
		Worker worker2 = new Worker("456", 28, "chen");
		Worker result = Optional.of(worker1).orElse(worker2);
		System.out.println(result.getName() + "," + result.getAge());
	}

	/**
	 * isPresent()表示如果Optional<T>封装的对象不为空，就返回true。
	 */
	public static void isPresentDemo() {
		Worker worker1 = new Worker("123", 18, "lin");
		Optional<Worker> workerOpt = Optional.ofNullable(worker1);
		//这种写法比较丑，可以直接用下面的ifPresent()方法代替。
		boolean isPresent = workerOpt.isPresent();
		if (isPresent) {
			System.out.println(workerOpt.get().getName());
		}
		//以上代码，相当于：
//		if (worker1 != null) {
//			System.out.println(worker1.getName());
//		}
	}

	/**
	 * ifPresent()表示如果对象不为null，则会执行对应的lambda语句。
	 */
	public static void ifPresentDemo() {
//		Address address=new Address("中国","广东","深圳");
//		Worker worker1=new Worker("123",18,"lin",address);
		Worker worker1 = new Worker("123", 18, "lin");
//		Worker worker1=null;
		List<String> nameList = new ArrayList<>();
		Optional.ofNullable(worker1).ifPresent(worker -> nameList.add(worker.getName()));
		//上面这句代码的作用相当于以下注释的代码：
//		if (worker1 != null) {
//			nameList.add(worker1.getName());
//		}
		nameList.forEach(System.out::println);
	}

	/**
	 * 这种大量的判空代码很丑。
	 */
	public static void tooMuchNull(Worker worker) {
//		if (worker != null) {
//			Address address=worker.getAddress();
//			if (address != null) {
//				String city=address.getCity();
//			}
//		}
	}


	/**
	 * flatMap()，如果Optional封装对象不为空，就会执行对应的mapping函数，返回Optional类型的值。
	 * 否则就返回一个空的Optional对象。
	 */
	public static void flatMapDemo() {
		Address address = new Address("中国", "广东", "深圳");
		Worker worker = new Worker("123", 18, "lin", address);
		//默认值为"default"，有没有更好的选择？
		String city = Optional.ofNullable(worker)
				.flatMap(Worker::getAdress)
				.flatMap(Address::getCity)
				.orElse("default");
		System.out.println(city);
	}

	/**
	 * orElseThrow(),如果Optional封装的对象为空，就会抛出对应的异常。
	 */
	public static void orElseThrowDemo() {
//		Worker worker = new Worker("123", 18, "lin");
		Worker worker = null;
		Worker result = Optional.ofNullable(worker)
				.orElseThrow(IllegalArgumentException::new);
		System.out.println(result.getName());
	}


	public static void filterDemo() {
		Worker worker = new Worker("123", 18, "lin");
		Optional<Worker> result = Optional.ofNullable(worker)
				.filter(worker1 -> worker1.getAge() > 20);
		//如果符合条件(比如，年龄大于20)则为true，不符合则为false
		System.out.println(result.isPresent());
	}

}
