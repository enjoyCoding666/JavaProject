package test.com.reflect; 

import com.reflect.Car;
import com.reflect.CarReflect;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* CarReflect Tester. 
* 
* @author <Authors name> 
* @since <pre>01/29/2018</pre> 
* @version 1.0 
*/ 
public class CarReflectTest {

    CarReflect carReflect;
    Car car;

    @Before
    public void before() throws Exception {
        carReflect=new CarReflect();
        car=new Car();
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
* Method: setPropertyByField(Object object, String fieldName, Object value) 
* 
*/ 
@Test
public void testSetPropertyByField() throws Exception { 
//TODO: Test goes here...
    Object object= carReflect.setPropertyByField(car,"color","黑色");

} 

/** 
* 
* Method: getPropertyByField(Object object, String fieldName) 
* 
*/ 
@Test
public void testGetPropertyByField() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setterByReflect(Object object, String methodName, Object value, Class<?> classType) 
* 
*/ 
@Test
public void testSetterByReflect() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getterByReflect(Object object, String methodName) 
* 
*/ 
@Test
public void testGetterByReflect() throws Exception { 
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

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here... 
} 


} 
