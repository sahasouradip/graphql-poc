package com.example.graphql.service;

import com.example.graphql.configuration.ServiceConfiguration;
import com.example.graphql.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ServiceConfiguration serviceConfiguration;

    public List<Contact> getContacts(String ssn) {
        return Arrays.asList(restTemplate.getForObject(serviceConfiguration.getContactBySocialSecurityNumber(ssn), Contact[].class));
    }
}
