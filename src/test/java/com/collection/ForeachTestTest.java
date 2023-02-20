package com.collection; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* ForeachTest Tester. 
* 
* @author <Authors name> 
* @since <pre>03/14/2020</pre> 
* @version 1.0 
*/ 
public class ForeachTestTest { 

	ForeachTest foreachTest=new ForeachTest();

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: foreachNull() 
* 
*/ 
@Test
public void testForeachNull() throws Exception { 
//TODO: Test goes here...
	foreachTest.foreachNPE();
}

@Test
public void testForeachJava8() throws Exception {
//TODO: Test goes here...
	foreachTest.foreachJave8();
}


} 
