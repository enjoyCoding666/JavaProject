package com.java8.stream;

import com.collection.ListOperation;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\4 0004 22:36
 * @Description:
 */
public class StreamCollectorTest {

	public static void listStringtoInteger() {
		List<String> strList=new ArrayList<>();
		strList.add("1");
		strList.add("2");
		strList.add("abc");
		//将list转化为流，然后过滤掉非数字的字符串，再将字符串转化为数字，最后转化回list。
		List<Integer> integerList = strList.stream().filter(StringUtils::isNumeric).map(Integer::valueOf).collect(Collectors.toList());
		integerList.forEach(System.out::println);
	}
}
