package com.imv.unit_testing.part2.controller;

import com.imv.unit_testing.part2.ItemRepository;
import com.imv.unit_testing.part2.model.Item;
import com.imv.unit_testing.part2.services.ItemBusinessServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    private ItemBusinessServiceImpl itemBusinessService;

    @Mock
    private ItemRepository repository;
//    List<Item> retreiveAllItems();
    @Test
    public void TestFindAllItems(){
        when(repository.findAll()).thenReturn(List.of(new Item(1,"Item2",30,20),
                new Item(2,"Item3",40,40)));
     List<Item> items= itemBusinessService.retreiveAllItems();
        Assertions.assertEquals(600,items.get(0).getValue());
        Assertions.assertEquals(1600,items.get(1).getValue());
    }
}
