//package com.imv.unit_testing.business;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//class SomeDataServiceStubTest implements SomeDataService {
//
//
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {1,2,3};
//    }
//}
//
//
//class SomeDataServiceStubTestNegative implements SomeDataService {
//
//
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {1,2,3,4};
//    }
//}
//
//class SomeDataServiceStubTestEmpty implements SomeDataService {
//
//
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {};
//    }
//}
//
//
//class SomeDataServiceStubTestOneValue implements SomeDataService {
//
//
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {5};
//    }
//}
//
//@SpringBootTest
//public class SomeBusinessStubTest {
//    @Test
//    public void calculateSum_basic(){
//        SomeBusinessImpl business = new SomeBusinessImpl();
//        business.setSomeDataService(new SomeDataServiceStubTest());
//        int actualResult= business.calculateSumUsingDataService();
//        int expectedResult=6;
//        Assertions.assertEquals(actualResult,expectedResult);
//    }
//
//    @Test
//    public void calculateSum_Negative(){
//        SomeBusinessImpl business = new SomeBusinessImpl();
//        business.setSomeDataService(new SomeDataServiceStubTestNegative());
//        int actualResult= business.calculateSumUsingDataService();
//        int expectedResult=6;
//        Assertions.assertNotEquals(actualResult,expectedResult);
//    }
//    @Test
//    public void calculateSum_empty(){
//        SomeBusinessImpl business = new SomeBusinessImpl();
//        business.setSomeDataService(new SomeDataServiceStubTestEmpty());
//        int actualResult= business.calculateSumUsingDataService();
//        int expectedResult=0;
//        Assertions.assertEquals(actualResult,expectedResult);
//    }
//    @Test
//    public void calculateSum_oneValue(){
//        SomeBusinessImpl business = new SomeBusinessImpl();
//        business.setSomeDataService(new SomeDataServiceStubTestOneValue());
//        int actualResult= business.calculateSumUsingDataService();
//        int expectedResult=5;
//        Assertions.assertEquals(actualResult,expectedResult);
//    }
//}
