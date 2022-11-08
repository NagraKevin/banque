package com.mabanque.app.services.bankAccount;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccountNumberGenerator implements com.mabanque.app.services.bankAccount.interfaces.AccountNumberGenerator {

    private static AtomicInteger accountNumber = new AtomicInteger(1);

    @Override
    public int generateAccountNumber() {
        int newAccountNumber =  accountNumber.getAndIncrement();
        return newAccountNumber;
    }
}
