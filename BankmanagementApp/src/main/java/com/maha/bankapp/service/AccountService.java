package com.maha.bankapp.service;
import com.maha.bankapp.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(Long accountno);
    public List<Account> getAllAccounts();
    public Account depositAmount(Long accountno, Double amount);
    public Account withdrawAmount(Long accountno, Double amount);
    public void closeAccount(Long accountno);
}
