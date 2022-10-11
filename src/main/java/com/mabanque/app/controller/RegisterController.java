package com.mabanque.app.controller;

import com.mabanque.app.entities.Customer;
import com.mabanque.app.interfaces.InterfaceRegisterCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private InterfaceRegisterCustomer interfaceRegisterCustomer;

    @PostMapping("/customer-with-account")
    public Customer registerCustomerWithAccount(@RequestBody Customer customer){
       return interfaceRegisterCustomer.saveCustomerWithAccount(customer);
    }

}
