package com.mabanque.app.services.customer;

import com.mabanque.app.controller.customer.CommandCustomer;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.controller.customer.RequestCustomerValidator;
import com.mabanque.app.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(CommandCustomer customer){

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setPassWord(customer.getPassword());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setBirthDate(customer.getBirthDate());

        return customerRepository.save(newCustomer);

    }

}
