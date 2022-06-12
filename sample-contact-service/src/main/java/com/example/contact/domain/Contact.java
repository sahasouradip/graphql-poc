package com.example.contact.domain;

import java.util.List;

public class Contact {
    private String socialSecurityNumber;
    private List<Address> addresses;
    private Email email;
    private List<Phone> phones;

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
                "ssn='" + socialSecurityNumber + '\'' +
                ", addresses=" + addresses +
                ", email=" + email +
                ", phones=" + phones +
                '}';
    }
}
