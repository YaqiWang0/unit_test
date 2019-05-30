package com.unittesting.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning(){
        String responseFromService = "[" +
                "{\"id\":10000 , \"name\":\"Pencil\", \"quantity\":5}," +
                "{\"id\":10001 , \"name\":\"Pen\", \"quantity\":15}," +
                "{\"id\":10002 , \"name\":\"Eraser\", \"quantity\":10}," +
                "]";
        DocumentContext parse = JsonPath.parse(responseFromService);
        int length=parse.read("$.length()");
        assertThat(length).isEqualTo(3);
        System.out.println(parse.read("$..id").toString());
        List<Integer> ids=parse.read("$..id");
        assertThat(ids).containsExactly(10000,10001,10002);
        System.out.println(parse.read("$.[1]").toString());
        //items from 0 to 2
        System.out.println(parse.read("$.[0:2]").toString());
        System.out.println(parse.read("$.[?(@.name=='Eraser')]").toString());
        System.out.println(parse.read("$.[?(@.quantity==5)]").toString());
    }
}
