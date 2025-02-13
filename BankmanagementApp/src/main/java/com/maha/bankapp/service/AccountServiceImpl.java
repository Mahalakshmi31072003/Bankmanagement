package com.maha.bankapp.service;

import com.maha.bankapp.entity.Account;
import com.maha.bankapp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        Account accountsaved = repo.save(account);
        return accountsaved;
    }

    @Override
    public Account getAccount(Long accountno) {
        Optional<Account> account =  repo.findById(accountno);
        if(account.isEmpty())
        {
            throw new RuntimeException("Account is present");
        }
        Account account1=account.get();

        return account1;
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> listofacc = repo.findAll();
        return listofacc;
    }

    @Override
    public Account depositAmount(Long accountno, Double amount) {
        Optional<Account> account=repo.findById(accountno);
        if(account.isEmpty())
        {
            throw new RuntimeException("Account is not present");
        }
        Account accountpre = account.get();
        Double totalbal = accountpre.getAccount_balance()+amount;
        accountpre.setAccount_balance(totalbal);
        repo.save(accountpre);
        return accountpre;
    }

    @Override
    public Account withdrawAmount(Long accountno, Double amount) {
        Optional<Account> account =  repo.findById(accountno);
        if(account.isEmpty())
        {
            throw new RuntimeException("Account is present");
        }
        Account accountpre=account.get();
        Double accountBal = accountpre.getAccount_balance()-amount;
        accountpre.setAccount_balance(accountBal);
        repo.save(accountpre);
        return accountpre;
    }

    @Override
    public void closeAccount(Long accountno) {
        getAccount(accountno);
        repo.deleteById(accountno);

    }
}
