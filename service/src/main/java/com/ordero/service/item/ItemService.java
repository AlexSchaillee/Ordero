package com.ordero.service.item;

import com.ordero.domain.item.Item;
import com.ordero.domain.item.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemService {

    private final ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item){
        return itemRepository.createItem(item);
    }

    /*public Item updateItem(Item item, Item updatedItem){
        return itemRepository.createUpdatedItem(item, updatedItem);
    }*/

}
