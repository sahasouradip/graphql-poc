package com.example.graphql.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Configuration
@ConfigurationProperties(prefix = "services")
public class ServiceConfiguration {
    private String customer;
    private String customerBySSN;
    private String contact;
    private String contactBySSN;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerBySSN() {
        return customerBySSN;
    }

    public void setCustomerBySSN(String customerBySSN) {
        this.customerBySSN = customerBySSN;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactBySSN() {
        return contactBySSN;
    }

    public void setContactBySSN(String contactBySSN) {
        this.contactBySSN = contactBySSN;
    }

    public String getCustomerBySocialSecurityNumber(String ssn) {
        return UriComponentsBuilder.fromHttpUrl(customer).path(customerBySSN).build().expand(Collections.singletonMap("ssn", ssn)).toString();
    }

    public String getContactBySocialSecurityNumber(String ssn) {
        return UriComponentsBuilder.fromHttpUrl(contact).path(contactBySSN).build().expand(Collections.singletonMap("ssn", ssn)).toString();
    }

}
