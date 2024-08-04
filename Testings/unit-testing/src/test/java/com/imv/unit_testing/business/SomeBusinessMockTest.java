package com.imv.unit_testing.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();
    @Mock
    SomeDataService dataServiceMock;


    @Test
    public void calculateSum_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        Assertions.assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_Negative() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{-1, 2, 3});
        Assertions.assertNotEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        Assertions.assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        Assertions.assertEquals(5, business.calculateSumUsingDataService());
    }
}
