package test.practise.JUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import practise.jUnit.SumUtil;

/** 
* SumUtil Tester. 
* 
* @author <Authors name>
* @version 1.0 
*/ 
public class SumUtilTest1 {

@Before
public void before() throws Exception {

    System.out.println("测试前的准备工作.....");

} 

@After
public void after() throws Exception {
    System.out.println("测试结束后的工作.....");
} 

/** 
* 
* Method: sum1(int x, int y) 
* 
*/ 
@Test
public void testSum1() throws Exception { 
//TODO: Test goes here...
    int result = SumUtil.sum1(2,1);
    Assert.assertEquals(result, 3);

} 

/** 
* 
* Method: sum2(int x, int y, int z) 
* 
*/ 
@Test
public void testSum2() throws Exception { 
//TODO: Test goes here...
    int result = SumUtil.sum2(1,2,4);
    Assert.assertEquals(result, 6);
} 


} 
