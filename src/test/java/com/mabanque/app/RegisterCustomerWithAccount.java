package com.mabanque.app;

import com.mabanque.app.entities.Customer;
import com.mabanque.app.model.CustomerMapper;
import com.mabanque.app.repository.CustomerRepository;
import com.mabanque.app.services.RegisterCustomerWithAccountServices;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class RegisterCustomerWithAccount {

    @Mock
    private CustomerRepository customerRepository;

    @Autowired
    private RegisterCustomerWithAccountServices registerCustomerWithAccountServices;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        registerCustomerWithAccountServices.setCustomerRepository(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Transactional
    public void when_save_customer_it_should_return_customer() {
        // given
        CustomerMapper customerMapper = new CustomerMapper("test","azerty123","3 sq jacques babinet","061010101010","test1@hotmail.fr","test");

        // when
        Customer savedCustomer = registerCustomerWithAccountServices.saveCustomerWithAccount(customerMapper);

        // then
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();
        assertThat(capturedCustomer).isEqualTo(savedCustomer);
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getFirstName()).isEqualTo("test");
    }


}
