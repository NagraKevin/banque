package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.interfaces.InterfaceIbanNumberGenerator;
import com.mabanque.app.interfaces.InterfaceRegisterBankAccount;
import com.mabanque.app.interfaces.InterfaceRegisterCustomer;
import com.mabanque.app.repository.BankAccountRepository;
import com.mabanque.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCustomerWithAccountServices implements InterfaceRegisterCustomer, InterfaceRegisterBankAccount {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InterfaceIbanNumberGenerator ibanNumberGenerator;

    @Override
    public Customer saveCustomerWithAccount(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        BankAccount bankAccount = new BankAccount(0, 1500, newCustomer);
        saveBankAccount(newCustomer, bankAccount);
        return newCustomer;
    }

    @Override
    public BankAccount saveBankAccount(Customer customer, BankAccount bankAccount) {
        String numIban = ibanNumberGenerator.generateIbanNumber(bankAccount);
        bankAccount.setIbanNumber(numIban);
        return bankAccountRepository.save(bankAccount);
    }

}
