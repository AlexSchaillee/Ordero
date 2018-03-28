package com.ordero.service.item;

import com.ordero.domain.item.Item;
import com.ordero.domain.item.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void addItem() {
        Item item = Item.ItemBuilder.itemBuilder()
                .withName("Product1")
                .withDescription("TesterProduct1")
                .withPrice(2.00)
                .withAmount(2)
                .build();

        Mockito.when(itemRepository.createItem(item)).thenReturn(item);

        Assertions.assertThat(itemService.addItem(item)).isEqualTo(item);
    }
}