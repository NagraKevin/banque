package com.mabanque.app.services.bankAccount.interfaces;

import com.mabanque.app.entities.BankAccount;

@FunctionalInterface
public interface IbanNumberGenerator {
    public String generateIbanNumber(BankAccount bankAccount);
}
