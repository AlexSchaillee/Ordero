
package com.ordero.api.customer;

import com.ordero.domain.customer.CustomerRepository;
import com.ordero.domain.databaseCustomer.CustomerDatabase;
import com.ordero.service.customer.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import static com.ordero.api.customer.CustomerDTO.customerDTO;
import static java.lang.String.format;
import static org.springframework.boot.SpringApplication.run;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerControllerIntegrationTest.CustomerControllerIntegrationTestRunner.class ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Inject
    private CustomerRepository customerRepository;

    @Test
    public void createCustomer() {
        //GIVEN
        CustomerDTO customerDTO = new TestRestTemplate()
                .postForObject(format("http://localhost:%s/%s", port, "customer"),
                        customerDTO()
                        .withFirstname("Test")
                        .withLastname("Tester1")
                        .withEmail("Test.Tester1@cm.be")
                        .withAddress("TestStreet A1, 0000 TestCity")
                        .withPhoneNumber("0000/00 00 00"), CustomerDTO.class);
        //THEN
        Assertions.assertThat(customerDTO.getFirstname()).isEqualTo("Test");
        Assertions.assertThat(customerDTO.getLastname()).isEqualTo("Tester1");
        Assertions.assertThat(customerDTO.getEmail()).isEqualTo("Test.Tester1@cm.be");
        Assertions.assertThat(customerDTO.getAddress()).isEqualTo("TestStreet A1, 0000 TestCity");
        Assertions.assertThat(customerDTO.getPhoneNumber()).isEqualTo("0000/00 00 00");
    }

    @SpringBootApplication(scanBasePackageClasses = {CustomerDatabase.class, CustomerRepository.class, CustomerService.class, CustomerMapper.class})
    public static class CustomerControllerIntegrationTestRunner {

        public static void main(String[] args) {
            run(CustomerControllerIntegrationTestRunner.class, args);
        }
    }
}


