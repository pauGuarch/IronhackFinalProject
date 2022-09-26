package com.ironhack.bank.controllers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;
import com.ironhack.bank.enums.Roles;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Transaction;
import com.ironhack.bank.repositories.AccountHolderRepository;
import com.ironhack.bank.repositories.AccountRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class TransactionControllerImplTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private TransactionRepository transactionRepository;

    private Transaction transaction;
    private Transaction transaction2;
    Date date = new Date(Calendar.getInstance().getTime().getTime());
    private final Money balance = new Money(BigDecimal.valueOf(100.00), Currency.getInstance("USD"));
    private final Money balance2 = new Money(BigDecimal.valueOf(30.00), Currency.getInstance("USD"));
    private final Money balance3 = new Money(BigDecimal.valueOf(200.00), Currency.getInstance("USD"));
    private final Money balance4 = new Money(BigDecimal.valueOf(400.00), Currency.getInstance("USD"));
    private final AccountHolder accountHolder = new AccountHolder("Juan", "juan_", "1234", date);
    private final AccountHolder accountHolder2 = new AccountHolder("Pedro", "pedro_", "qwerty", date);
    private final AccountHolder accountHolder3 = new AccountHolder("Ana", "ana_", "asdfg", date);
    private final AccountHolder accountHolder4 = new AccountHolder("Moskovskaia", "mosko_", "zxcvb", date);
    private final Account account = new Account(balance, "qwerty", accountHolder,accountHolder2, AccountStatus.ACTIVE);
    private final Account account2 = new Account(balance2, "1234", accountHolder3,accountHolder4, AccountStatus.ACTIVE);
    private final Account account3 = new Account(balance3, "asdfg", accountHolder3,accountHolder4,  AccountStatus.ACTIVE);
    private final Account account4 = new Account(balance4, "zzxxcc", accountHolder3,accountHolder4,  AccountStatus.ACTIVE);

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        transaction = new Transaction(account, account2, BigDecimal.valueOf(100.00));
        accountHolderRepository.save(accountHolder3);
        accountHolderRepository.save(accountHolder4);
        accountRepository.save(account3);
        accountRepository.save(account4);
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
    @Test
    void test_deleteTransaction() throws Exception{
        transaction2 = transactionRepository.save(transaction2);
        MvcResult mvcResult = mockMvc.perform(delete("/transaction/"+transaction2.getId())).andReturn();

        assertEquals(204,  mvcResult.getResponse().getStatus());
    }
}