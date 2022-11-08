package com.mabanque.app.configuration;

import com.mabanque.app.services.bankAccount.Iban4jNumberGenerator;
import com.mabanque.app.services.bankAccount.interfaces.IbanNumberGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositionRoot {

    @Bean
    public IbanNumberGenerator ibanNumberGenerator() {
        return new Iban4jNumberGenerator();
    }

}
