package com.java8.localdate; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* LocalDateDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>05/02/2020</pre> 
* @version 1.0 
*/ 
public class LocalDateDemoTest { 
	private LocalDateDemo localDateDemo=new LocalDateDemo();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: timeToString() 
* 
*/ 
@Test
public void testTimeToString() throws Exception { 
//TODO: Test goes here...
	localDateDemo.timeToString();
} 

/** 
* 
* Method: stringToTime() 
* 
*/ 
@Test
public void testStringToTime() throws Exception { 
//TODO: Test goes here...
	localDateDemo.stringToTime();
} 

/** 
* 
* Method: generateLocalDate() 
* 
*/ 
@Test
public void testGenerateLocalDate() throws Exception { 
//TODO: Test goes here...
	localDateDemo.generateLocalDate();
} 

/** 
* 
* Method: getLocalDateTimeMonth() 
* 
*/ 
@Test
public void testGetLocalDateTimeMonth() throws Exception { 
//TODO: Test goes here...
	localDateDemo.getLocalDateTimeMonth();
} 

/** 
* 
* Method: monthDiff() 
* 
*/ 
@Test
public void testMonthDiff() throws Exception { 
//TODO: Test goes here...
	localDateDemo.monthDiff();
}

	@Test
	public void testAddMonthDay() throws Exception {
//TODO: Test goes here...
		localDateDemo.addMonthDay();
	}
} 
