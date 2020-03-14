package com.string;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\3\14 0014 22:51
 * @Description:
 */
public class SplitDemo {
	/**
	 * 使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无
	 * 内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。
	 */
	public void splitStr() {
		String str = "a,b,c,,";
		String[] ary = str.split(",");
		// 预期大于 3，结果是 3
		int length=ary.length;
		System.out.println(ary[length- 1]);
	}
}
