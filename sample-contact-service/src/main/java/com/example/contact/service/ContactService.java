package com.example.contact.service;

import com.example.contact.domain.Contact;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Value("classpath:sample.json")
    private Resource resourceFile;

    private List<Contact> contacts;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws IOException {
        var objectMapper = new ObjectMapper();
        contacts = objectMapper.readValue(resourceFile.getFile(), new TypeReference<List<Contact>>() {
        });
    }

    public List<Contact> getContact(String ssn) {
        return contacts.stream().filter(contact -> contact.getSocialSecurityNumber().equalsIgnoreCase(ssn)).collect(Collectors.toList());
    }
}
