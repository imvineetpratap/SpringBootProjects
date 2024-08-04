package com.imv.unit_testing.part2.controller;

import com.imv.unit_testing.part2.controllers.DummyController;

import com.imv.unit_testing.part2.model.Item;
import com.imv.unit_testing.part2.services.ItemBusinessService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DummyController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basicTest() throws Exception {
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/dummy-world")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\": 1,\"name\":\"Pens\",\"quantity\":20,\"price\":30}"))
                .andReturn();
//        JSONAssert.assertEquals();
    }


    @Test
    public void dummyItem_CheckControllerMethodCallingServiceLayer() throws Exception {
       when(itemBusinessService.retreiveHardcodedItem()).thenReturn(new Item(1,"Pens",20,30));
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("{id: 1,name:Pens,quantity:20,price:30,value:1}"))
                .andReturn();
//        JSONAssert.assertEquals();
    }


    @Test
    public void dummyItem_AllitemsFromTheDatabase() throws Exception {
        when(itemBusinessService.retreiveAllItems()).thenReturn(Arrays.asList(new Item(1,"Item2",10,10),
                new Item(2,"Item3",10,10)));
        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);


        MvcResult mvcResult=mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(content().json("[{id: 1,name:Item2,quantity:10,price:10}," +
                        "{id: 2,name:Item3,quantity:10,price:10}]"))
                .andReturn();
//        JSONAssert.assertEquals();
    }
}
