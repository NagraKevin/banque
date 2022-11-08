package com.mabanque.app.services.bankAccount;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.services.bankAccount.interfaces.IbanNumberGenerator;
import org.iban4j.CountryCode;
import org.iban4j.Iban;

public class Iban4jNumberGenerator implements IbanNumberGenerator {

    @Override
    public String generateIbanNumber(BankAccount bankAccount) {
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.AT)
                .bankCode("93420")
                .accountNumber(String.format("%011d", bankAccount.getAccountNumber()))
                .build();
        return iban.toString();
    }

}
