package com.wiltech.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(path = "/customers/", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // customerRepository definition and getCustomers() method

    @RequestMapping(path = "/customers/{customerId}/contacts/", method = RequestMethod.GET)
    public List<Contact> getCustomerContacts(@PathVariable("customerId") Long customerId) {
        return customerRepository.findOne(customerId).getContacts();
    }
}
