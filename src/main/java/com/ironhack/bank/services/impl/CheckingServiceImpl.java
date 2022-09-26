package com.ironhack.bank.services.impl;

import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.Checking;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.CheckingRepository;
import com.ironhack.bank.services.interfaces.CheckingService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CheckingServiceImpl implements CheckingService {
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Checking getCheckingById(Integer id) {
        Optional<Checking> checkingOptional = checkingRepository.findById(id);

        if (checkingOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking not found");
        }

        return checkingOptional.get();
    }

    @Override
    public Checking saveChecking(Checking checking) {
        /*if (checking.getId() != null && checkingRepository.existsById(checking.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This id: " + checking.getId() + " already exists for another checking");
        }*/
        //Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, AccountStatus status
        /*Account account = new Account(checking.getBalance(), checking.getSecretKey(), checking.getPrimaryOwner(), checking.getSecondaryOwner(), checking.getPenaltyFee(), checking.getStatus());
        accountRepository.save(account);
        List<Account> accounts = accountRepository.findAll();
        Integer accountId = accounts.get(accounts.size()-1).getId();
        Checking check1 = new Checking(checking.getMonthlyMaintenanceFee());
        check1.setId(accountId);*/
        return checkingRepository.save(checking);
    }

    @Override
    public void deleteChecking(Integer checkingId) {
        Checking checking = getCheckingById(checkingId);
        checkingRepository.delete(checking);
    }
}
