package com.imv.unit_testing.business;

import java.util.Arrays;

public class SomeBusinessImpl {
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    private SomeDataService someDataService;


    //this was simple method to test methods

    public int calculateSum(int[] data)
    {
       return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService(){
        int[] data=someDataService.retrieveAllData();
        return Arrays.stream(data).sum();
    }
}
