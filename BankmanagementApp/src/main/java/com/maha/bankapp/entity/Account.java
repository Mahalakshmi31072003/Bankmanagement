package com.maha.bankapp.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long accountno;

    @Column
    private String accountholder_name;

    @Column
    private Double account_balance;
    public Account()
    {

    }

    public Account(Double account_balance, String accountholder_name) {
        this.account_balance = account_balance;
        this.accountholder_name = accountholder_name;
    }

    public long getAccountno() {
        return accountno;
    }

    public void setAccountno(long accountno) {
        this.accountno = accountno;
    }

    public String getAccountholder_name() {
        return accountholder_name;
    }

    public void setAccountholder_name(String accountholder_name) {
        this.accountholder_name = accountholder_name;
    }

    public Double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountno=" + accountno +
                ", accountholder_name='" + accountholder_name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }

}
