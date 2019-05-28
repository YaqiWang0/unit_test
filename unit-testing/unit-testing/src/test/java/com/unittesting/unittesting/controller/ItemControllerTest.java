package com.unittesting.unittesting.controller;

import com.unittesting.unittesting.business.ItemBusinessService;
import com.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;
    @Test
    void dummyItem() throws Exception{
        RequestBuilder request=
                MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        MvcResult result=
                mockMvc.perform(request).andExpect(status().isOk()).andExpect( content().json(
                        "{\"id\":1,\"name\":\"Ball\",\"price\":10}")).andReturn();

    }

    @Test
    void itemFromBusinessService() throws Exception {
        given(businessService.retreiveHardcodedItem()).willReturn(new Item(1,"Ball",10,10));
        RequestBuilder request=
                MockMvcRequestBuilders
                        .get("/item-from-business-service")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result=
                mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andExpect( content().json(
                        "{id:1,name:Ball,price:10}")).andReturn();
    }

    @Test
    void retrieveAllItems() throws Exception {
        given(businessService.retrieveAllItems()).willReturn(Arrays.asList(new Item(1,"Ball",10,10)));
        RequestBuilder request=
                MockMvcRequestBuilders
                        .get("/all-items-from-database")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult result=
                mockMvc.perform(request)
                        .andExpect(status().isOk())
                        .andExpect( content().json(
                                "[{id:1,name:Ball,price:10}]")).andReturn();
    }
}