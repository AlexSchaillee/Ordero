package com.ordero.domain.customer;

import com.ordero.domain.databaseCustomer.CustomerDatabase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerRepository {

    @Inject
    private CustomerDatabase customerDatabase;

    public CustomerRepository(CustomerDatabase customerDatabase) {
        this.customerDatabase = customerDatabase;
    }

    public Customer createCustomer (Customer customer){
        return customerDatabase.addCustomerToDatabase(customer);
    }
}
