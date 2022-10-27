package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.model.CustomerMapper;
import com.mabanque.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(CustomerMapper customer){

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setPassWord(customer.getPassword());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setPhoneNumber(customer.getPhoneNumber());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setBirthDate(customer.getBirthDate());
        newCustomer.setAccounts(customer.getAccounts());

        return customerRepository.save(newCustomer);

    }

}
