package com.collection;

import com.collection.MapOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/** 
* MapOperation Tester. 
* 
* @author <Authors name> 
* @since <pre>02/26/2018</pre> 
* @version 1.0 
*/ 
public class MapOperationTest {
    Map map1=new HashMap();
    Map map2=new TreeMap();
    Map map3=new LinkedHashMap();

@Before
public void before() throws Exception {
    map1.put("5","str5");
    map1.put("b","str3");
    map1.put("1","str1");
    map1.put("2","str2");
    map1.put("4","str4");

    map2.put("3","str3");
    map2.put("1","str1");
    map2.put("2","str2");
    map2.put("4","str4");

    map3.put("3","str3");
    map3.put("1","str1");
    map3.put("2","str2");
    map3.put("4","str4");
} 

@After
public void after() throws Exception { 
}

@Test
  public void testErgodicMap() throws Exception {
//TODO: Test goes here...
        MapOperation.ergodicMap(map1);
        System.out.println("遍历TreeMap如下：");
        MapOperation.ergodicMap(map2);
        System.out.println("遍历LinkedHashMap如下：");
        MapOperation.ergodicMap(map3);
    }

 /**
* 
* Method: mapToString(Map<String, String> map) 
* 
*/ 
@Test
public void testMapToString() throws Exception { 
//TODO: Test goes here...

} 


} 
