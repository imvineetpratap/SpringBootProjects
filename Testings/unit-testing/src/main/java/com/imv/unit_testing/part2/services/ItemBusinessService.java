package com.imv.unit_testing.part2.services;

import com.imv.unit_testing.part2.model.Item;

import java.util.List;

public interface ItemBusinessService {
    Item retreiveHardcodedItem();
    List<Item> retreiveAllItems();
}
