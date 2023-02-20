package com.collection; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
* ListOperation Tester. 
* 
* @author <Authors name> 
* @since <pre>09/09/2019</pre> 
* @version 1.0 
*/ 
public class ListOperationTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: ergodic(List<String> list) 
* 
*/ 
@Test
public void testErgodic() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: ergodicByIterator(List<String> list) 
* 
*/ 
@Test
public void testErgodicByIterator() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: arraysToList(String[] strArray) 
* 
*/ 
@Test
public void testArraysToList() throws Exception { 
//TODO: Test goes here...
    String[] stryArray=new String[]{"str1","str2","str3"};
    ListOperation operation=new ListOperation();
    List<String> list= Arrays.asList(stryArray);
    List<String> strList=new ArrayList<>(list);
    strList.add("test");
    for (Object str:list){
        System.out.println(str);
    }
} 

@Test
public  void testListToArrays(){
    ListOperation operation=new ListOperation();
    List<String> strList=new ArrayList<>();
    strList.add("str1");
    strList.add("str2");
    Object[] arrays=strList.toArray();
    System.out.println(arrays[0]);


}



} 
