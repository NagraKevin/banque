package com.mabanque.app.model;

import com.mabanque.app.entities.Customer;

public class BankAccountMapper {

    private Customer customer;

    public BankAccountMapper(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
