package com.imv.unit_testing.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SomeBusinessTest {

    @Test
    public void calculateSum_basic(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult= business.calculateSum(new int[]{1,2,3});
        int expectedResult=6;
        Assertions.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void calculateSum_Negative(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult= business.calculateSum(new int[]{1,2,3,4});
        int expectedResult=6;
        Assertions.assertNotEquals(actualResult,expectedResult);
    }
    @Test
    public void calculateSum_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult= business.calculateSum(new int[]{});
        int expectedResult=0;
        Assertions.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void calculateSum_oneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult= business.calculateSum(new int[]{5});
        int expectedResult=5;
        Assertions.assertEquals(actualResult,expectedResult);
    }
}
