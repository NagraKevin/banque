package com.mabanque.app.interfaces;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.entities.Customer;

public interface InterfaceRegisterBankAccount {
    public BankAccount saveBankAccount(Customer customer, BankAccount bankAccount);
}
