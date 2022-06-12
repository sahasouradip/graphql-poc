package com.example.graphql.service;

import com.example.graphql.configuration.ServiceConfiguration;
import com.example.graphql.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ServiceConfiguration serviceConfiguration;

    public Customer getCustomer(String ssn) {
        return restTemplate.getForObject(serviceConfiguration.getCustomerBySocialSecurityNumber(ssn), Customer.class);
    }

}
