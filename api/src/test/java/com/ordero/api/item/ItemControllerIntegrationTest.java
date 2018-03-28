package com.ordero.api.item;

import com.ordero.domain.databaseItem.ItemDatabase;
import com.ordero.domain.item.ItemRepository;
import com.ordero.service.item.ItemService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.ordero.api.item.ItemDTO.itemDTO;
import static java.lang.String.format;
import static org.junit.Assert.*;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemControllerIntegrationTest.ItemControllerTestRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private ItemRepository itemRepository;

    @Test
    public void createItem() {
        ItemDTO itemDTO = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", port, "item"),
                    itemDTO().withName("Product1")
                    .withDescription("blablabla")
                    .withPrice(2.00)
                    .withAmount(2),
        ItemDTO.class);

        Assertions.assertThat(itemDTO.getName()).isEqualTo("Product1");
        Assertions.assertThat(itemDTO.getDescription()).isEqualTo("blablabla");
        Assertions.assertThat(itemDTO.getPrice()).isEqualTo(2.00);
        Assertions.assertThat(itemDTO.getAmount()).isEqualTo(2);
    }

    @SpringBootApplication(scanBasePackageClasses = {ItemRepository.class, ItemMapper.class, ItemService.class, ItemDatabase.class})
    public static class ItemControllerTestRunner{
        public static void main(String[] args){
            run(ItemControllerTestRunner.class,args);
        }
    }
}
