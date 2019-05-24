package com.unittesting.unittesting.business;

import com.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl business=new SomeBusinessImpl();
        int actualResult=business.calculateSum(new int[] {});
        int expectedResult=0;
        assertEquals(expectedResult,actualResult);

    }


    @Test
    public void calculateSumUsingDataService() {

        SomeDataService dataService=mock(SomeDataService.class);
        when(dataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        SomeBusinessImpl business=new SomeBusinessImpl(dataService);
        int result=business.calculateSumUsingDataService();

    }
}