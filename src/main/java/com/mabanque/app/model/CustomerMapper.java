package com.mabanque.app.model;

import com.mabanque.app.entities.BankAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerMapper {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private Collection<BankAccount> accounts;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Collection<BankAccount> getAccounts() {
        return accounts;
    }

    public CustomerMapper(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.accounts = new ArrayList<>();
    }
}
