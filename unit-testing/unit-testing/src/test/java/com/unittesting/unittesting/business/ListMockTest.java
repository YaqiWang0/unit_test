package com.unittesting.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List mock=mock(List.class);
    @Test
    public void size_basic() {

        when(mock.size()).thenReturn(5);
        assertEquals(5,mock.size());

    }
    @Test
    public void returnDifferentValues(){

        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mock.size());
        assertEquals(10,mock.size());

    }
    @Test
    public void returnWithParameters(){
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes",mock.get(0));
        assertEquals(null,mock.size());


    }

    @Test
    public void calculateSumUsingDataService() {
        mock.add("Some values");
        mock.add("Some values");
        ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());
        assertThat(captor.getAllValues().get(0),is("Some values"));
        assertThat(captor.getAllValues().get(1),is("Some values"));
    }
}