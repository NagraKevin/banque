package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.model.BankAccountMapper;
import com.mabanque.app.model.CustomerMapper;
import com.mabanque.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCustomerWithAccountService {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomerWithAccount(CustomerMapper customerMapper) {
        Customer newCustomer = customerService.saveCustomer(customerMapper);
        BankAccountMapper bankAccountMapper = new BankAccountMapper(newCustomer);
        BankAccount bankAccount = bankAccountService.saveBankAccount(bankAccountMapper);
        newCustomer.addAccountToCustomer(bankAccount);
        return newCustomer;
    }




}
