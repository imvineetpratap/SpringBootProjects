package com.imv.unit_testing.part2.services;

import com.imv.unit_testing.part2.ItemRepository;
import com.imv.unit_testing.part2.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService{
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item retreiveHardcodedItem() {
        return new Item(1,"Pens",20,30);
    }
    public List<Item> retreiveAllItems() {

       List<Item> items= itemRepository.findAll();
       items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
//        items.stream().forEach(item -> item.setValue(item.getPrice()*item.getQuantity()));
        return items;
    }
}
