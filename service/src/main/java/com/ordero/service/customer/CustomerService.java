package com.ordero.service.customer;

import com.ordero.domain.customer.Customer;
import com.ordero.domain.customer.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerCustomer(Customer customer){
        return customerRepository.createCustomer(customer);
    }
}
