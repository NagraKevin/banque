package com.mabanque.app.controller.customer;

import com.mabanque.app.entities.Customer;
import com.mabanque.app.services.customer.RegisterCustomerWithAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private RegisterCustomerWithAccountService registerCustomer;

    @PostMapping("/register")
    public Customer registerCustomerWithAccount( @Valid @RequestBody RequestCustomerValidator requestCustomerValidator){
        CommandCustomer commandCustomer = requestCustomerValidator.toCommandCustomer();
       return registerCustomer.saveCustomerWithAccount(commandCustomer);
    }



}
