package com.collection;

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\14 0014 22:35
 * @Description:
 */
public class ForeachTest {
	/**
	 * 注意，使用foreach遍历的时候，也要进行判空操作，规避空指针
	 *
	 */
	public void foreachNPE() {
		String str=null;
		List<String> list= Arrays.asList("abc", "def", str);
		//foreach不判空，也会报空指针
		for (String letter : list) {
			System.out.println(letter.length());
		}
	}

	public void removeElement() {
		//如果采用Arrays.asList()，是不能对集合进行增删操作的。
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		//想要遍历集合，删除元素，必须使用Iterator()。如果使用foreach()，会报错。
		//removeIf()，内部使用的就是Iterator()。
		list.removeIf(Objects::isNull);
	}


	/**
	 * java8中提供了非常方便的过滤以及遍历的操作。
	 *
	 */
	public void foreachJave8() {
		String str=null;
		List<String> list= Arrays.asList("abc", "def", str);
		list.stream().filter(StringUtils::isNotEmpty).forEach(System.out::println);
	}

}
