package com.ironhack.bank.services.impl;

import com.ironhack.bank.classes.Money;
import com.ironhack.bank.enums.AccountStatus;
import com.ironhack.bank.models.Account;
import com.ironhack.bank.models.AccountHolder;
import com.ironhack.bank.models.Checking;
import com.ironhack.bank.models.StudentChecking;
import com.ironhack.bank.repositories.AccountHolderRepository;
import com.ironhack.bank.repositories.AccountRepository;
import com.ironhack.bank.repositories.CheckingRepository;
import com.ironhack.bank.repositories.StudentCheckingRepository;
import com.ironhack.bank.services.interfaces.CheckingService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class CheckingServiceImpl implements CheckingService {
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Override
    public Checking getCheckingById(Integer id) {
        Optional<Checking> checkingOptional = checkingRepository.findById(id);
        if (checkingOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking not found");
        }
        //Resta del penaltyFee cuando la cuenta está por debajo del minimumBalance
        if(checkingOptional.get().getBalance().getAmount().compareTo(checkingOptional.get().getMinimumBalance())<0){
            Money newBalance = new Money( checkingOptional.get().getBalance().getAmount().subtract(checkingOptional.get().getPenaltyFee()), checkingOptional.get().getBalance().getCurrency());
            checkingOptional.get().setBalance(newBalance);
            checkingRepository.save(checkingOptional.get());
        }
        return checkingOptional.get();
    }

    @Override
    public Account saveChecking(Checking checking) {
        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(checking.getPrimaryOwner().getId());
        if(accountHolder.isPresent()){
            Period period = Period.between(accountHolder.get().getDateOfBirth().toLocalDate(), LocalDate.now());
            if(period.getYears()<24) {
                StudentChecking studentChecking = new StudentChecking(checking.getBalance(), checking.getSecretKey(),
                        checking.getPrimaryOwner(), checking.getSecondaryOwner(),
                        checking.getStatus(), checking.getCreationDate());
                return studentCheckingRepository.save(studentChecking);
            }
        }
            return checkingRepository.save(checking);
    }

    @Override
    public void deleteChecking(Integer checkingId) {
        Checking checking = getCheckingById(checkingId);
        checkingRepository.delete(checking);
    }
}
