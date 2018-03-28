package com.ordero.api.item;

import com.ordero.domain.item.Item;

import javax.inject.Named;

@Named
public class ItemMapper {

    public ItemDTO toDto(Item item){
        return ItemDTO.itemDTO()
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice())
                .withAmount(item.getAmount());
    }

    public Item toDomain(ItemDTO itemDTO){
        return new Item.ItemBuilder()
                .withName(itemDTO.getName())
                .withDescription(itemDTO.getDescription())
                .withPrice(itemDTO.getPrice())
                .withAmount(itemDTO.getAmount())
                .build();
    }
}
