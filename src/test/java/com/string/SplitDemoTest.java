package com.string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SplitDemo Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/14/2020</pre>
 */
public class SplitDemoTest {
	SplitDemo splitDemo = new SplitDemo();

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: splitStr()
	 */
	@Test
	public void testSpilitStr() throws Exception {
//TODO: Test goes here...
		splitDemo.splitStr();
	}


	@Test
	public void testSpilitError() throws Exception {
//TODO: Test goes here...

//	String str = ",a";
//		String str = "a,";
		String str = ",";
//	String str = "";
//	String str = " ";
//	String str = "abc";
		splitDemo.splitError(str);
	}

	@Test
	public void testSpilitRegex() throws Exception {
//TODO: Test goes here...
		splitDemo.splitRegex();
	}

	@Test
	public void testSplitSpace() {
		splitDemo.splitSpace();
	}

} 
