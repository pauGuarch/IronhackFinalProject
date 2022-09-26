package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Transaction;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.TransactionRepository;
import com.ironhack.bank.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountServiceImpl accountService;
    @Override
    public Transaction getTransactionById(Integer id) {
        System.out.println("id----->"+ id);
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        if (transactionOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        }
        return transactionOptional.get();
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        //get del origin i del destiny, comprobar saldos i ajuste de amount de cuentas.

        if (transaction.getId() != null && transactionRepository.existsById(transaction.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + transaction.getId() + " already exists for another Student");
        }else if (transaction.getDestinyAccount().getId()==null || transaction.getOriginAccount().getId()==null){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "You have to enter destiny and origin account Id's.");
        }

        Account origin = accountService.getAccountById(transaction.getOriginAccount().getId());
        Account destiny = accountService.getAccountById(transaction.getDestinyAccount().getId());
        if (origin.getBalance().getAmount().subtract(transaction.getAmount()).compareTo(BigDecimal.valueOf(0.00))<0){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "ERROR. The transaction amount is bigger than the origin account's balance.");
        }else{
            accountService.subtractAccountBalance(origin.getId(), transaction.getAmount());
            accountService.increaseAccountBalance(destiny.getId(), transaction.getAmount());
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Integer transactionId) {
        Transaction transaction = getTransactionById(transactionId);
        transactionRepository.delete(transaction);
    }
}
