package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

@Service
public class IbanNumberGenerator implements com.mabanque.app.interfaces.IbanNumberGenerator {

    @Override
    public String generateIbanNumber(BankAccount bankAccount) {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("93420")
                .accountNumber(String.format("%011d",bankAccount.getAccountNumber()))
                .build();
        return iban.toString();
    }
}
