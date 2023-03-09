package test.com.java8.stream; 

import com.java8.stream.SortedDateDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SortedDemo Tester. 
* 
* @author <Authors name> 
* @since <pre>3 , 9, 2023</pre>
* @version 1.0 
*/ 
public class SortedDateDemoTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: orderSort() 
* 
*/ 
@Test
public void testOrderSort() throws Exception { 
//TODO: Test goes here...
    SortedDateDemo sortedDateDemo = new SortedDateDemo();
    sortedDateDemo.orderSort();
    Assert.assertNotNull(sortedDateDemo);
} 

/** 
* 
* Method: toDate(String dateTimeStr, String pattern) 
* 
*/ 
@Test
public void testToDate() throws Exception { 
//TODO: Test goes here... 
} 


} 
