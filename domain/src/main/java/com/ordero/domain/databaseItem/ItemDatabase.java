package com.ordero.domain.databaseItem;

import com.ordero.domain.item.Item;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ItemDatabase {

    private List<Item> itemList;

    public ItemDatabase() {
        this.itemList = new ArrayList<>();
    }

    public Item addItemToDatabase(Item item) {
        itemList.add(item);
        return item;
    }
}
