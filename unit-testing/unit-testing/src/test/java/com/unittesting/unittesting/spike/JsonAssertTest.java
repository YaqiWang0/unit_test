package com.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse= "{\"id\":1,\"name\":\"Ball\"," +
            "\"price\":10,\"quantity\":100}";

    @Test
    public void JsonAssertTest() throws JSONException {
        String expectedResponse="{\"name\":\"Ball\"," +
                "\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,
                actualResponse,false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacter() throws Exception{
        String expectedResponse="{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expectedResponse,
                actualResponse,false);
    }
}
