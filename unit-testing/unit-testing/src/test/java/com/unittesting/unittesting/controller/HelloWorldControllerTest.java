package com.unittesting.unittesting.controller
        ;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.swing.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void helloWorld_basic() throws Exception {

        RequestBuilder request =
                MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        // Or the states().isOk()
        MvcResult result=
                mockMvc.perform(request).andExpect(status().is(200)).andExpect(content().
                        string("Hello World")).andReturn();
        assertThat(result.getResponse().getContentAsString(),
                is("Hello World"));
        //call "/hello-world"
        //verify "Hello World"
    }
}