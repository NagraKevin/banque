package com.mabanque.app;

import com.mabanque.app.controller.customer.CommandCustomer;
import com.mabanque.app.entities.Customer;
import com.mabanque.app.controller.customer.RequestCustomerValidator;
import com.mabanque.app.repository.CustomerRepository;
import com.mabanque.app.services.customer.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class CustomerServiceTest {

    private CustomerRepository customerRepositoryMock;

    @Autowired
    private CustomerService customerService;

    private AutoCloseable autoCloseable;

    private RequestCustomerValidator requestCustomerValidator;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Transactional
    @DisplayName("check if customer is saved with the right properties")
    public void when_save_customer_it_should_return_customer(){
        //given
        requestCustomerValidator = new RequestCustomerValidator("test","azerty123", LocalDate.of(1992, Month.JUNE, 14),"3 sq jacques babinet","061010101010","test1@hotmail.fr","test");
        CommandCustomer commandCustomer = requestCustomerValidator.toCommandCustomer();
        //when
        Customer savedCustomer = customerService.saveCustomer(commandCustomer);

        //then
        //ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        //verify(customerRepositoryMock).save(customerArgumentCaptor.capture());
        assertThat(savedCustomer.getFirstName()).isEqualTo(commandCustomer.getFirstName());
        assertEquals(commandCustomer.getBirthDate(),savedCustomer.getBirthDate());
    }



}
