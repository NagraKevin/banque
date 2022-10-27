package com.mabanque.app;

import com.mabanque.app.entities.Customer;
import com.mabanque.app.model.CustomerMapper;
import com.mabanque.app.services.RegisterCustomerWithAccountService;
import org.junit.jupiter.api.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Nested
@DisplayName("When i create a new customer with bank account")
public class RegisterCustomerWithAccountTest {

    @Autowired
    private RegisterCustomerWithAccountService registerCustomerWithAccountService;

    private AutoCloseable autoCloseable;

    private CustomerMapper customerMapper;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Transactional
    @DisplayName("Then it should create new customer")
    public void when_save_customer_it_should_return_customer() {
        // given
        customerMapper = new CustomerMapper("test","azerty123", LocalDate.of(1992, Month.JUNE, 14),"3 sq jacques babinet","061010101010","test1@hotmail.fr","test");

        // when
        Customer savedCustomer = registerCustomerWithAccountService.saveCustomerWithAccount(customerMapper);

        // then
        assertAll(
                ()-> assertThat(savedCustomer).isNotNull(),
                () -> assertEquals(customerMapper.getFirstName(),savedCustomer.getFirstName()),
                () -> assertEquals(customerMapper.getBirthDate(), savedCustomer.getBirthDate())
        );
    }

    @Test
    @Transactional
    @DisplayName("Then it should create new bank account for the customer created")
    public void when_save_customer_with_account_it_should_create_bank_Account() {
        // given
        customerMapper = new CustomerMapper("test 2","azerty123", LocalDate.of(1992, Month.JUNE, 14),"3 sq jacques babinet","061010101010","test2@hotmail.fr","test");

        // when
        Customer savedCustomer = registerCustomerWithAccountService.saveCustomerWithAccount(customerMapper);

        // then
        assertThat(savedCustomer).isNotNull();
        savedCustomer.getAccounts().forEach(bankAccount ->
                assertEquals("test 2" ,bankAccount.getCustomer().getFirstName())
        );
        savedCustomer.getAccounts().forEach(bankAccount ->
                assertEquals(savedCustomer.getId() ,bankAccount.getCustomer().getId())
        );
        assertEquals(1, savedCustomer.getAccounts().size());
    }
}
