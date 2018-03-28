package com.ordero.api.item;

import com.ordero.domain.item.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemMapperTest {

    private ItemMapper itemMapper;

    @Before
    public void instantiateMapper(){
        itemMapper = new ItemMapper();
    }

    @Test
    public void toDto() {
        Item item = Item.ItemBuilder.itemBuilder()
                .withName("Product1")
                .withDescription("blablabla")
                .withPrice(2.00)
                .withAmount(2)
                .build();

        ItemDTO itemDTO = itemMapper.toDto(item);

        Assertions.assertThat(itemDTO.getName()).isEqualTo(item.getName());
        Assertions.assertThat(itemDTO.getDescription()).isEqualTo(item.getDescription());
        Assertions.assertThat(itemDTO.getPrice()).isEqualTo(item.getPrice());
        Assertions.assertThat(itemDTO.getAmount()).isEqualTo(item.getAmount());
    }

    @Test
    public void toDomain() {
        ItemDTO itemDTO = ItemDTO.itemDTO()
                .withName("Product1")
                .withDescription("blablabla")
                .withPrice(2.00)
                .withAmount(2);

        Item item = itemMapper.toDomain(itemDTO);

        Assertions.assertThat(item.getName()).isEqualTo(itemDTO.getName());
        Assertions.assertThat(item.getDescription()).isEqualTo(itemDTO.getDescription());
        Assertions.assertThat(item.getPrice()).isEqualTo(itemDTO.getPrice());
        Assertions.assertThat(item.getAmount()).isEqualTo(itemDTO.getAmount());
    }
}