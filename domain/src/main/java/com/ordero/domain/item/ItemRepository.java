package com.ordero.domain.item;

import com.ordero.domain.databaseItem.ItemDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemRepository {

    @Inject
    private ItemDatabase itemDatabase;

    public ItemRepository(ItemDatabase itemDatabase){
        this.itemDatabase = itemDatabase;
    }

    public Item createItem(Item item){
        return itemDatabase.addItemToDatabase(item);
    }
}
