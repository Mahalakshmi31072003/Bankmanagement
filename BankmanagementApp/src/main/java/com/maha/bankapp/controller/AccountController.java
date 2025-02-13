package com.maha.bankapp.controller;

import com.maha.bankapp.entity.Account;
import com.maha.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account)
    {
        Account createAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
    }

    @GetMapping("/{accountno}")
    public Account getAccountByAccountNumber(@PathVariable Long accountno)
    {
        Account account=service.getAccount(accountno);
        return account;
    }

    @GetMapping("/getallaccounts")
    public List<Account> getAllAccounts()
    {
        List<Account> allAccountDetails = service.getAllAccounts();
        return allAccountDetails;
    }

    @PutMapping("/deposit/{accountno}/{amount}")
    public Account depositAccount(@PathVariable Long accountno,@PathVariable Double amount )
    {
        Account account = service.depositAmount(accountno,amount);
        return account;
    }

    @PutMapping("/withdraw/{accountno}/{amount}")
    public Account withdrawAccount(@PathVariable Long accountno,@PathVariable Double amount )
    {
        Account account = service.withdrawAmount(accountno,amount);
        return account;
    }

    @DeleteMapping("/delete/{accountno}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountno)
    {
        service.closeAccount(accountno);
        return ResponseEntity.ok("Account closed");
        
    }

        

}
