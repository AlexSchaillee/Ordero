package com.ordero.api.customer;

public class CustomerDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String phoneNumber;

    private CustomerDTO(){}

    public static CustomerDTO customerDTO() {
        return new CustomerDTO();
    }

    public CustomerDTO withFirstname(String firstname){
        this.firstname = firstname;
        return this;
    }

    public CustomerDTO withLastname(String lastname){
        this.lastname = lastname;
        return this;
    }

    public CustomerDTO withEmail(String email){
        this.email = email;
        return this;
    }

    public CustomerDTO withAddress(String address){
        this.address = address;
        return this;
    }

    public CustomerDTO withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
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
}
