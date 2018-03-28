package com.ordero.domain.item;

import com.ordero.domain.databaseItem.ItemDatabase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ItemRepositoryTest {

    private ItemDatabase itemDatabaseMock;

    private ItemRepository customerRepository;

    @Test
    public void createItem() {
        Item item = Item.ItemBuilder.itemBuilder()
                .withName("Product1")
                .withDescription("TesterProduct")
                .withPrice(2.00)
                .withAmount(2)
                .build();
        itemDatabaseMock = Mockito.mock(ItemDatabase.class);
        customerRepository = new ItemRepository(itemDatabaseMock);

        Mockito.when(itemDatabaseMock.addItemToDatabase(item)).thenReturn(item);

        Assertions.assertThat(customerRepository.createItem(item)).isEqualTo(item);
    }
}