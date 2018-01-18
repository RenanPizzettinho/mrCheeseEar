package com.estagiario.mrcheese.repository;

import com.estagiario.mrcheese.model.Item;

public class ItemRepository extends BasicRepository<Item, Long>{

    public ItemRepository() {
        super(Item.class);
    }
}
