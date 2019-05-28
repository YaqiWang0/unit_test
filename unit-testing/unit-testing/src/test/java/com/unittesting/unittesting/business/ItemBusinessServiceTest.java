package com.unittesting.unittesting.business;

import com.unittesting.unittesting.data.ItemRepository;
import com.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService businessService;

    @Mock
    private ItemRepository repository;

    @Test
    public void retreiveHardcodedItem() {
    }

    @Test
    public void retrieveAllItems() {
        given(repository.findAll()).willReturn(Arrays.asList(new Item(2,"Item2",10,10),new Item(3,"Item3",20,20)));
        List<Item> items=businessService.retrieveAllItems();
        assertEquals(100,items.get(0).getValue());
        assertEquals(400,items.get(1).getValue());
    }
}