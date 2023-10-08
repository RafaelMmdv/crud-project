package com.project.crudspr.service;

import com.project.crudspr.entity.Customer;
import com.project.crudspr.exception.CustomerNotFoundException;
import com.project.crudspr.exception.CustomerNotNullException;
import com.project.crudspr.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired

    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){

        if(customer.getName().isBlank() || customer.getName().isEmpty()){

            throw new CustomerNotNullException("Customer name must be not null");
        }

        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId){

        return customerRepository.findById(customerId).get();
    }

    public void deleteCustomerById(Long customerId){

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer = optionalCustomer.orElseThrow(() -> new CustomerNotFoundException("Customer Id: " + customerId));

        customerRepository.deleteById(customerId);
    }


}

