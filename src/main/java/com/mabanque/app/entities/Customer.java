package com.mabanque.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(nullable = false)
   private String firstName;

   @Column(nullable = false)
   private String lastName;

   @Column(nullable = false)
   private LocalDate birthDate;

   @Column(nullable = false)
   private String address;

   @Column(unique = true)
   private String phoneNumber;

   @Column(unique = true)
   private String email;

   private String password;

   @JsonIgnore
   @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
   private Collection<BankAccount> accounts;

   public Customer(String firstName, String lastName, LocalDate birthDate, String address, String phoneNumber, String email, String password, ArrayList<BankAccount> bankAccounts){
      this.firstName = firstName;
      this.lastName = lastName;
      this.birthDate = birthDate;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.password = password;
      this.accounts = bankAccounts;
   }

   public Customer(){

   }

   public long getId() {
      return id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public LocalDate getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(LocalDate birthDate) {
      this.birthDate = birthDate;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassWord(String password) {
      this.password = password;
   }

   public Collection<BankAccount> getAccounts() {
      return accounts;
   }

   public void setAccounts(Collection<BankAccount> accounts) {
      this.accounts = accounts;
   }

   public void addAccountToCustomer(BankAccount bankAccount){
      this.getAccounts().add(bankAccount);
   }
}
