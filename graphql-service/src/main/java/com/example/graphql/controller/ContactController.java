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
public class ContactController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ContactService contactService;

    /*
    type Query {
        contacts(socialSecurityNumber: String!): [Contact]
    }
    */

    @QueryMapping
    public List<Contact> contacts(@Argument("socialSecurityNumber") String ssn) {
        return contactService.getContacts(ssn);
    }

    /*
    type Contact {
        ...
        customer: Customer // Rest call to customer service
    }
    */
    @SchemaMapping(typeName="Contact", field="customer")
    public Customer releases(Contact contact) {
        return customerService.getCustomer(contact.getSocialSecurityNumber());
    }

}
