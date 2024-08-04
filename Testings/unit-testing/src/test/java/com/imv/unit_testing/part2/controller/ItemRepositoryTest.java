package com.imv.unit_testing.part2.controller;

import com.imv.unit_testing.part2.ItemRepository;
import com.imv.unit_testing.part2.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
   private ItemRepository repository;
    @Test
    public void testfindAll() {
        List<Item> items = repository.findAll();
        Assertions.assertEquals(3,items.size());
    }
}
