package com.ordero.domain.databaseCustomer;

import com.ordero.domain.customer.Customer;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
public class CustomerDatabase {

    private List<Customer> customerList;

    public CustomerDatabase() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList(){
        return Collections.unmodifiableList(customerList);
    }

    public Customer addCustomerToDatabase(Customer customer){
        customerList.add(customer);
        return customer;
    }


}
