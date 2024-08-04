package com.imv.unit_testing.part2.controller;

import com.imv.unit_testing.part2.controllers.HelloWorld;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HelloWorld.class)
public class HelloWorldTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld() throws Exception {
        //call "/hello-world"
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders
                        .get("/hello-world")
                        .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))  //this line is duplicating below in assert
                .andReturn();
        //verify "Hello World"
        Assertions.assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}
