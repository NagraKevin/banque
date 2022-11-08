package com.mabanque.app.services.bankAccount.interfaces;

@FunctionalInterface
public interface AccountNumberGenerator {
    public int generateAccountNumber();
}