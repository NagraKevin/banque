package com.mabanque.app.model;

import java.util.Date;

public class CustomerMapper {
    String firstName;
    String lastName;
    Date birthDate;
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

    public Date getBirthDate() {
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
}
