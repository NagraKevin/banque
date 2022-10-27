package com.mabanque.app.services;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.model.BankAccountMapper;
import com.mabanque.app.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountService {

    @Autowired
    private AccountNumberGenerator accountNumberGenerator;

    @Autowired
    private IbanNumberGenerator ibanNumberGenerator;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public BankAccount saveBankAccount(BankAccountMapper bankAccountMapper) {
        BankAccount bankAccount = new BankAccount();
        int accountNumber = accountNumberGenerator.generateAccountNumber();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setCustomer(bankAccountMapper.getCustomer());
        String numIban = ibanNumberGenerator.generateIbanNumber(bankAccount);
        bankAccount.setIbanNumber(numIban);
        return bankAccountRepository.save(bankAccount);
    }


}
