package com.example.graphql.controller;

import com.example.graphql.domain.Contact;
import com.example.graphql.domain.Customer;
import com.example.graphql.service.ContactService;
import com.example.graphql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContactService contactService;

    /*
    type Query {
        customer(socialSecurityNumber: String!): Customer
    }
    */

    @QueryMapping
    public Customer customer(@Argument("socialSecurityNumber") String ssn) {
        return customerService.getCustomer(ssn);
    }

    /*
    type Customer {
        ...
        contacts: [Contact] // Rest call to contact service
    }
    */
    @SchemaMapping(typeName="Customer", field="contacts")
    public List<Contact> releases(Customer customer) {
        return contactService.getContacts(customer.getSocialSecurityNumber());
    }
}
