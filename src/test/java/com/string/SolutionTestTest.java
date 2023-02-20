package com.string;

import com.string.SolutionTest;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;

/** 
* SolutionTest Tester. 
* 
* @author <Authors name> 
* @since <pre>09/18/2022</pre> 
* @version 1.0 
*/ 
public class SolutionTestTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: fun(int wanCount) 
* 
*/ 
@Test
public void testFun() throws Exception { 
//TODO: Test goes here...
    ArrayList<Integer> fun = new SolutionTest().fun(6);
    for (Integer integer : fun) {
        System.out.println(integer);
    }
} 


} 
