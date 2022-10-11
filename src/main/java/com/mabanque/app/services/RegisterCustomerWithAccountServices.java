package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.interfaces.AccountNumberGenerator;
import com.mabanque.app.interfaces.IbanNumberGenerator;
import com.mabanque.app.repository.BankAccountRepository;
import com.mabanque.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCustomerWithAccountServices {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IbanNumberGenerator ibanNumberGenerator;

    @Autowired
    private AccountNumberGenerator accountNumberGenerator;


    public Customer saveCustomerWithAccount(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        BankAccount bankAccount = new BankAccount(0, 1500, newCustomer);
        saveBankAccount(newCustomer, bankAccount);
        return newCustomer;
    }

    public BankAccount saveBankAccount(Customer customer, BankAccount bankAccount) {
        int accountNumber = accountNumberGenerator.generateAccountNumber();
        bankAccount.setAccountNumber(accountNumber);
        String numIban = ibanNumberGenerator.generateIbanNumber(bankAccount);
        bankAccount.setIbanNumber(numIban);
        return bankAccountRepository.save(bankAccount);
    }

}
