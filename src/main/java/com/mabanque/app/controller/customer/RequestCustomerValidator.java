package com.mabanque.app.controller.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class RequestCustomerValidator {

    @NotNull
    @NotBlank(message = "Name is mandatory")
    private String firstName;
    @NotNull
    private String lastName;
    @Past
    private LocalDate birthDate;
    @NotNull
    private String address;
    private String phoneNumber;
    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String password;


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

    public RequestCustomerValidator(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public CommandCustomer toCommandCustomer() {
        CommandCustomer commandCustomer =new CommandCustomer();
        commandCustomer.setFirstName(this.getFirstName());
        commandCustomer.setLastName(this.getLastName());
        commandCustomer.setBirthDate(this.getBirthDate());
        commandCustomer.setAddress(this.getAddress());
        commandCustomer.setPhoneNumber(this.getPhoneNumber());
        commandCustomer.setEmail(this.getEmail());
        commandCustomer.setPassword(this.getPassword());
        return commandCustomer;

    }
}
