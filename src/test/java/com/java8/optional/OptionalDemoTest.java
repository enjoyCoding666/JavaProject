package com.java8.optional; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

/** 
* optionalDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>03/06/2020</pre> 
* @version 1.0 
*/ 
public class OptionalDemoTest {
	private OptionalDemo optionalDemo;
@Before
public void before() throws Exception {
	optionalDemo=new OptionalDemo();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: orElseDemo() 
* 
*/ 
@Test
public void testOrElseDemo() throws Exception { 
//TODO: Test goes here...
	optionalDemo.orElseDemo();
} 

/** 
* 
* Method: ofDemo() 
* 
*/ 
@Test
public void testOfDemo() throws Exception { 
//TODO: Test goes here...
	optionalDemo.ofDemo();
}

@Test
public void testIfPresentDemo() throws Exception {
//TODO: Test goes here...
	optionalDemo.ifPresentDemo();
}

/**
 *
 * Method: tooMuchNull(Worker worker)
 *
 */
@Test
public void testTooMuchNull() throws Exception {
//TODO: Test goes here...
}

/**
 *
 * Method: litteNull()
 *
 */
@Test
public void testLitteNull() throws Exception {
//TODO: Test goes here...
	optionalDemo.flatMapDemo();
}

@Test
public void testIsPresentDemo() throws Exception {
//TODO: Test goes here...
	optionalDemo.isPresentDemo();
}

@Test
public void testElseGetDemo() throws Exception {
//TODO: Test goes here...
	optionalDemo.ofElseGetDemo();
}

@Test
public void testFilterDemo() throws Exception {
//TODO: Test goes here...
	optionalDemo.filterDemo();
}

@Test
public void testOrElseThrow() throws Exception {
//TODO: Test goes here...
	optionalDemo.orElseThrowDemo();
}

@Test
public void testMapDemo2() throws Exception {
//TODO: Test goes here...
	optionalDemo.mapDemo2();
}

@Test
public void testMapDemo() throws Exception {
//TODO: Test goes here...
	optionalDemo.mapDemo();
}


}

