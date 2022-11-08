package com.mabanque.app.services.bankAccount;

import com.mabanque.app.entities.BankAccount;
import com.mabanque.app.services.bankAccount.interfaces.AccountNumberGenerator;
import com.mabanque.app.repository.BankAccountRepository;
import com.mabanque.app.services.bankAccount.interfaces.IbanNumberGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountService {

    private AccountNumberGenerator accountNumberGenerator;

    private IbanNumberGenerator ibanNumberGenerator;

    private BankAccountRepository bankAccountRepository;

    public BankAccountService(AccountNumberGenerator accountNumberGenerator, IbanNumberGenerator ibanNumberGenerator, BankAccountRepository bankAccountRepository) {
        this.accountNumberGenerator = accountNumberGenerator;
        this.ibanNumberGenerator = ibanNumberGenerator;
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        int accountNumber = accountNumberGenerator.generateAccountNumber();
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setCustomer(bankAccount.getCustomer());
        String numIban = ibanNumberGenerator.generateIbanNumber(bankAccount);
        bankAccount.setIbanNumber(numIban);
        return bankAccountRepository.save(bankAccount);
    }

}
