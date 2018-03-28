package com.ordero.service.customer;

import com.ordero.domain.customer.Customer;
import com.ordero.domain.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void registerCustomer() {
        //GIVEN
        Customer customer = Customer.CustomerBuilder.customerBuilder()
                .withFirstname("Tester1")
                .withLastname("Tester2")
                .withEmail("Tester1.Tester2@cm.be")
                .withAddress("StreetTest 1A, 1111 TesterTown")
                .withPhoneNumber("0400/00 00 00")
                .build();

        //WHEN
        Mockito.when(customerRepository.createCustomer(customer)).thenReturn(customer);

        //THEN
        Assertions.assertThat(customerService.registerCustomer(customer)).isEqualTo(customer);
    }
}