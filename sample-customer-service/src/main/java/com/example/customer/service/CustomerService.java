package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Value("classpath:sample.json")
    private Resource resourceFile;

    private List<Customer> customers;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws IOException {
        var objectMapper = new ObjectMapper();
        customers = objectMapper.readValue(resourceFile.getFile(), new TypeReference<List<Customer>>() {
        });

    }

    public Optional<Customer> getPersonById(String ssn) {
        return customers.stream().filter(customer -> customer.getSocialSecurityNumber().equalsIgnoreCase(ssn)).findFirst();
    }
}
