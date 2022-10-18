package com.mabanque.app.model;

import java.time.LocalDate;
import java.util.Date;

public class CustomerMapper {

    String firstName;
    String lastName;
    LocalDate birthDate;
    String address;
    String phoneNumber;
    String email;
    String password;

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

    public CustomerMapper(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }
}
