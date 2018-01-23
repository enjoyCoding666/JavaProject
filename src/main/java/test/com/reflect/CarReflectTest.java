package test.com.reflect; 

import com.reflect.CarReflect;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* CarReflect Tester.
* 
* @author <Authors name> 
* @since <pre>1 23, 2018</pre>
* @version 1.0 
*/ 
public class CarReflectTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getClassName() 
* 
*/ 
@Test
public void testGetClassName() throws Exception { 
//TODO: Test goes here...
    new CarReflect().getClassName();
} 


} 
