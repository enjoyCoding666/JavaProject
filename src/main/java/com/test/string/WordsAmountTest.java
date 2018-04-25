package com.test.string;

import com.string.WordsAmount;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* WordsAmount Tester.
* 
* @author <Authors name> 
* @since <pre>ÈýÔÂ 23, 2017</pre> 
* @version 1.0 
*/ 
public class WordsAmountTest {
    WordsAmount wa;
    String str;
@Before
public void before() throws Exception {
    wa=new WordsAmount();
    str="May you have enough happiness to make you sweet,\n" +
            "enough trials to make you strong,enough sorrow to keep you human,\n" +
            "enough hope to make you happy? Always put yourself in others¡¯shoes.\n" +
            "If you feel that it hurts you,it probably hurts the other person, too.";
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
* Method: countWords(String str) 
* 
*/ 
@Test
public void testCountWords() throws Exception { 
//TODO: Test goes here...
    wa.countWords(str);
} 

/** 
* 
* Method: printMap(MapOperation<String,Integer> map)
* 
*/ 
@Test
public void testPrintMap() throws Exception { 
//TODO: Test goes here...
    wa.printMap(wa.countWords(str));
} 


} 
