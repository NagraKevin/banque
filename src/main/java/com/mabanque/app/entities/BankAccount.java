package com.mabanque.app.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;


@Entity
@Table(name="bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , updatable = false)
    private int accountNumber;

    @Column(unique = true)
    private String ibanNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date openDate =new Date();

    private double amount = 0;

    private int maxAmount = 10000;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    public BankAccount(int accountNumber, String ibanNumber, Date openDate, double amount, int maxAmount, Customer customer) {
        this.accountNumber = accountNumber;
        this.ibanNumber = ibanNumber;
        this.openDate = openDate;
        this.amount = amount;
        this.maxAmount = maxAmount;
        this.customer = customer;

    }

    public BankAccount() {

    }

    public long getId() {
        return id;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
