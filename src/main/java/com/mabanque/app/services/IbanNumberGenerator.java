package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.interfaces.InterfaceIbanNumberGenerator;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

@Service
public class IbanNumberGenerator implements InterfaceIbanNumberGenerator {

    @Override
    public String generateIbanNumber(BankAccount bankAccount) {
        System.out.println("ON ENTRE BIEN ICI");
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("93420")
                .accountNumber(String.format("%011d",bankAccount.getAccountNumber()))
                .build();
        System.out.println(iban.toString() + " NUMMMMM");
        return iban.toString();
    }
}
