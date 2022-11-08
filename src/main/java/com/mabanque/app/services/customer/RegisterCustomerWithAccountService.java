package com.mabanque.app.services.customer;

import com.mabanque.app.controller.customer.CommandCustomer;
import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.controller.customer.RequestCustomerValidator;
import com.mabanque.app.services.bankAccount.BankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterCustomerWithAccountService {

    private BankAccountService bankAccountService;

    private CustomerService customerService;

    public RegisterCustomerWithAccountService(BankAccountService bankAccountService, CustomerService customerService) {
        this.bankAccountService = bankAccountService;
        this.customerService = customerService;
    }

    @Transactional
    public Customer saveCustomerWithAccount(CommandCustomer customerMapper) {
        Customer newCustomer = customerService.saveCustomer(customerMapper);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setCustomer(newCustomer);
        bankAccountService.saveBankAccount(bankAccount);
        return newCustomer;
    }

}
