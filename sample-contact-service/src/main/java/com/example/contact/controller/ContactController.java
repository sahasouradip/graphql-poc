package com.example.contact.controller;

import com.example.contact.domain.Contact;
import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/{ssn}")
    public List<Contact> getContactsBySsn(@PathVariable String ssn) {
        return  contactService.getContact(ssn);
    }
}
