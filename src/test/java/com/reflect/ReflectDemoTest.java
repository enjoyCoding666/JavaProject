package com.reflect;

import com.reflect.ReflectDemo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* ReflectDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>$month $year</pre> 
* @version 1.0 
*/ 
public class ReflectDemoTest { 
   ReflectDemo reflectDemo=new ReflectDemo();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: initByReflect() 
* 
*/ 
@Test
public void testInitByReflect() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setPropertyByField() 
* 
*/ 
@Test
public void testSetPropertyByField() throws Exception { 
//TODO: Test goes here...
    reflectDemo.setPropertyByField();
} 

/** 
* 
* Method: getPropertyByField() 
* 
*/ 
@Test
public void testGetPropertyByField() throws Exception { 
//TODO: Test goes here...
    reflectDemo.getPropertyByField();
} 

/** 
* 
* Method: setterByReflect() 
* 
*/ 
@Test
public void testSetterByReflect() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: initByDefaultConst() 
* 
*/ 
@Test
public void testInitByDefaultConst() throws Exception { 
//TODO: Test goes here...
    reflectDemo.initByDefaultConst();
} 

/** 
* 
* Method: getClassName() 
* 
*/ 
@Test
public void testGetClassName() throws Exception { 
//TODO: Test goes here... 
} 


} 
