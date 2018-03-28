package com.ordero.api.customer;

import com.ordero.domain.customer.Customer;

import javax.inject.Named;

@Named
public class CustomerMapper {

    public CustomerDTO toDto(Customer customer){
        return CustomerDTO.customerDTO()
                .withFirstname(customer.getFirstname())
                .withLastname(customer.getLastname())
                .withEmail(customer.getEmail())
                .withAddress(customer.getAddress())
                .withPhoneNumber(customer.getPhoneNumber());
    }

    public Customer toDomain (CustomerDTO customerDTO){
        return new Customer.CustomerBuilder()
                .withFirstname(customerDTO.getFirstname())
                .withLastname(customerDTO.getLastname())
                .withEmail(customerDTO.getEmail())
                .withAddress(customerDTO.getAddress())
                .withPhoneNumber(customerDTO.getPhoneNumber())
                .build();
    }
}
