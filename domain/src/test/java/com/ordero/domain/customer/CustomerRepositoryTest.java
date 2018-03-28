package com.ordero.domain.customer;

import com.ordero.domain.databaseCustomer.CustomerDatabase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerRepositoryTest {

    private CustomerDatabase customerDatabaseMock;

    private CustomerRepository customerRepository;

    @Test
    public void createCustomer() {
        Customer customer = Customer.CustomerBuilder.customerBuilder()
                .withFirstname("Test")
                .withLastname("Tester1")
                .withEmail("Test.Tester1@cm.be")
                .withAddress("TesterStreet 1A, 1111 TesterCity")
                .withPhoneNumber("0000/00.00.00")
                .build();
        customerDatabaseMock = Mockito.mock(CustomerDatabase.class);
        customerRepository = new CustomerRepository(customerDatabaseMock);

        Mockito.when(customerDatabaseMock.addCustomerToDatabase(customer)).thenReturn(customer);

        Assertions.assertThat(customerRepository.createCustomer(customer)).isEqualTo(customer);
    }
}
// NO TEST WERE FOUND????       Exception in thread "main" java.lang.NoClassDefFoundError: org/hamcrest/SelfDescribing
