package test.com.bit; 

import com.bit.BitDemo;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BitDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>6, 6, 2022</pre>
* @version 1.0 
*/ 
public class BitDemoTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: andDemo(int num1, int num2) 
* 
*/ 
@Test
public void testAndDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.andDemo(8, 7);
} 

/** 
* 
* Method: orDemo(int num1, int num2) 
* 
*/ 
@Test
public void testOrDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.orDemo(8, 7);
} 

/** 
* 
* Method: XorDemo(int num1, int num2) 
* 
*/ 
@Test
public void testXorDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.xorDemo(8, 7);
} 

/** 
* 
* Method: ReverseDemo(int num) 
* 
*/ 
@Test
public void testReverseDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.reverseDemo(5);
} 

/** 
* 
* Method: leftDemo(int num) 
* 
*/ 
@Test
public void testLeftDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.leftDemo(10);
} 

/** 
* 
* Method: rightDemo(int num) 
* 
*/ 
@Test
public void testRightDemo() throws Exception { 
//TODO: Test goes here...
    BitDemo.rightDemo(20);
} 


} 
