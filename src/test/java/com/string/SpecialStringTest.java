package com.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SpecialString Tester.
* 
* @author <Authors name> 
* @since <pre>09/18/2022</pre> 
* @version 1.0 
*/ 
public class SpecialStringTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: isTarget(String str) 
* 
*/ 
@Test
public void testIsTarget() throws Exception { 
//TODO: Test goes here...
    boolean abba = SpecialString.isTarget("abba");
    Assert.assertTrue(abba);
} 


} 
