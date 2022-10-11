package com.mabanque.app.entities;

import jakarta.persistence.*;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

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

    private double amount;

    private int maxAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Transient
    private static AtomicInteger generateAccountNumber = new AtomicInteger(1);

    public BankAccount(double amount, int maxAmount, Customer customer) {
        this.amount = amount;
        this.maxAmount = maxAmount;
        this.customer = customer;
        this.accountNumber = generateAccountNumber.getAndIncrement();
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
}
