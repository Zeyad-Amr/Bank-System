package com.bank.atm.service;

import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public interface PersonalTransaction {

    void deposit(Account account, double amount, String description);

    void withdraw(Account account, double amount, String description);

    void transfer(Account account, double amount, String description, String payToID);

    void credit(Account account, double amount, String description, String paymentFor);

}
