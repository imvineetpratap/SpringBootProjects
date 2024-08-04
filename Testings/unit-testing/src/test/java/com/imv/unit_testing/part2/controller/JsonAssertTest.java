package com.imv.unit_testing.part2.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
String actualResponse="{\"id\": 1,\"name\":\"Pens\",\"quantity\":20,\"price\":30}";

    @Test
    public void JsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expected="{\"id\": 1,\"name\":\"Pens\",\"quantity\":20,\"price\":30}";
        JSONAssert.assertEquals(expected,actualResponse,true);
    }
    @Test
    public void JsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
        String expected="{\"id\": 1,\"name\":\"Pens\",\"price\":30}";
        JSONAssert.assertEquals(expected,actualResponse,false);
    }

    @Test
    public void JsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expected="{id: 1,name:Pens,price:30}";
        //        {id: 1,name:\"Pens 2\",price:30}
        JSONAssert.assertEquals(expected,actualResponse,false);
    }

}
