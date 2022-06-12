package com.example.graphql.domain;

import java.util.List;

public class Contact {
    private String socialSecurityNumber;
    private List<Address> addresses;
    private Email email;
    private List<Phone> phones;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", addresses=" + addresses +
                ", email=" + email +
                ", phones=" + phones +
                ", customer=" + customer +
                '}';
    }
}
