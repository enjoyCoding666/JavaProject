package com.java8.lambda;

import com.bean.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\14 0014 23:45
 * @Description:
 */
public class LambdaDemo {

	public void lambdaNonNull() {
		List<Worker> workerList = new ArrayList<>();
		Worker worker = new Worker("123", 18, "lin");
		workerList.add(worker);
		workerList.add(null);
		//过滤掉为空的对象，然后遍历
//		workerList.stream().filter(x->x!=null).forEach(System.out::println);
		workerList.stream().filter(Objects::nonNull).forEach(System.out::println);
	}
}
