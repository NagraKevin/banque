package com.mabanque.app.controller;

import com.mabanque.app.entities.Customer;
import com.mabanque.app.model.CustomerMapper;
import com.mabanque.app.services.RegisterCustomerWithAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterCustomerWithAccountServices registerCustomer;

    @PostMapping("/customer-with-account")
    public Customer registerCustomerWithAccount(@RequestBody CustomerMapper customer){
       return registerCustomer.saveCustomerWithAccount(customer);
    }

}
