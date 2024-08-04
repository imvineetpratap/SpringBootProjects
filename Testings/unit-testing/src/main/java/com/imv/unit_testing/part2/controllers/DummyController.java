package com.imv.unit_testing.part2.controllers;

import com.imv.unit_testing.part2.model.Item;
import com.imv.unit_testing.part2.services.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyController {
    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-world")
    public Item helloItem() {
        return new Item(1,"Pens",20,30);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retreiveHardcodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> allItemsFromDatabase() {
        return itemBusinessService.retreiveAllItems();
    }
}
