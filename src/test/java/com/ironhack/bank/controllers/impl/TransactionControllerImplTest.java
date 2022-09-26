package com.ironhack.bank.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;
import com.ironhack.bank.enums.Roles;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Transaction;
import com.ironhack.bank.repositories.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class TransactionControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction;
    private Transaction transaction2;
    Date date = new Date(Calendar.getInstance().getTime().getTime());
    private Money balance = new Money(BigDecimal.valueOf(100.00), Currency.getInstance("USD"));
    private Money balance2 = new Money(BigDecimal.valueOf(30.00), Currency.getInstance("USD"));
    private Money balance3 = new Money(BigDecimal.valueOf(200.00), Currency.getInstance("USD"));
    private Money balance4 = new Money(BigDecimal.valueOf(400.00), Currency.getInstance("USD"));
    private AccountHolder accountHolder = new AccountHolder("Juan", "juan_", "1234", date);
    private AccountHolder accountHolder2 = new AccountHolder("Pedro", "pedro_", "qwerty", date);
    private AccountHolder accountHolder3 = new AccountHolder("Ana", "ana_", "asdfg", date);
    private AccountHolder accountHolder4 = new AccountHolder("Moskovskaia", "mosko_", "zxcvb", date);
    private Account account = new Account(balance, "qwerty", accountHolder,accountHolder2, BigDecimal.valueOf(100), AccountStatus.ACTIVE);
    private Account account2 = new Account(balance2, "qwerty", accountHolder3,accountHolder4, BigDecimal.valueOf(50), AccountStatus.ACTIVE);
    private Account account3 = new Account(balance3, "qwerty", accountHolder3,accountHolder4, BigDecimal.valueOf(50), AccountStatus.ACTIVE);
    private Account account4 = new Account(balance4, "qwerty", accountHolder3,accountHolder4, BigDecimal.valueOf(50), AccountStatus.ACTIVE);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        transaction = new Transaction(account, account2, BigDecimal.valueOf(100.00));
        transaction2 = new Transaction(account3, account4, BigDecimal.valueOf(200.00));
    }
    @AfterEach
    void tearDown() {
        transactionRepository.deleteAll();
    }
    @Test
    void test_postTransaction() throws Exception {
        String body = objectMapper.writeValueAsString(transaction);
        MvcResult mvcResult = mockMvc.perform(post("/transaction")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(406,  mvcResult.getResponse().getStatus());
    }



}