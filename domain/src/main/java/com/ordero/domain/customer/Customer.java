package com.ordero.domain.customer;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phoneNumber;

    private Customer(String firstname, String lastname, String email, String address, String phoneNumber) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public Customer setId(UUID id){
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(firstname, customer.firstname) &&
                Objects.equals(lastname, customer.lastname) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, email, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class CustomerBuilder{

        private String firstname;
        private String lastname;
        private String email;
        private String address;
        private String phoneNumber;

        public static CustomerBuilder customerBuilder(){
            return new CustomerBuilder();
        }

        public CustomerBuilder withFirstname (String firstname) {
            this.firstname = firstname;
            return this;
        }

        public CustomerBuilder withLastname (String lastName) {
            this.lastname = lastName;
            return this;
        }

        public CustomerBuilder withEmail (String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withAddress (String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhoneNumber (String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build(){
            return new Customer(firstname,lastname,email,address,phoneNumber);
        }
    }
}
