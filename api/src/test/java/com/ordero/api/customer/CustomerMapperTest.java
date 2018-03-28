package com.ordero.api.customer;

import com.ordero.domain.customer.Customer;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @Before
    public void instantiateMapper(){
        customerMapper = new CustomerMapper();
    }
    @Test
    public void toDto() {
        Customer customer = Customer.CustomerBuilder.customerBuilder()
                .withFirstname("Test")
                .withLastname("Tester1")
                .withEmail("Test.Tester1@cm.be")
                .withAddress("TestStreet 1A, 1111 TestCityy")
                .withPhoneNumber("0000/00 00 00")
                .build();

        CustomerDTO customerDTO = customerMapper.toDto(customer);

        Assertions.assertThat(customerDTO.getFirstname()).isEqualTo(customer.getFirstname());
        Assertions.assertThat(customerDTO.getLastname()).isEqualTo(customer.getLastname());
        Assertions.assertThat(customerDTO.getEmail()).isEqualTo(customer.getEmail());
        Assertions.assertThat(customerDTO.getAddress()).isEqualTo(customer.getAddress());
        Assertions.assertThat(customerDTO.getPhoneNumber()).isEqualTo(customer.getPhoneNumber());
    }

    @Test
    public void toDomain() {
        CustomerDTO customerDTO = CustomerDTO.customerDTO()
                .withFirstname("Test")
                .withLastname("Tester1")
                .withEmail("Test.Tester1@cm.be")
                .withAddress("TEstStreet 1A, 1111 TestCity")
                .withPhoneNumber("0000/00 00 00");

        Customer customer = customerMapper.toDomain(customerDTO);

        Assertions.assertThat(customer.getFirstname()).isEqualTo(customerDTO.getFirstname());
        Assertions.assertThat(customer.getLastname()).isEqualTo(customerDTO.getLastname());
        Assertions.assertThat(customer.getEmail()).isEqualTo(customerDTO.getEmail());
        Assertions.assertThat(customer.getAddress()).isEqualTo(customerDTO.getAddress());
        Assertions.assertThat(customer.getPhoneNumber()).isEqualTo(customerDTO.getPhoneNumber());
    }
}