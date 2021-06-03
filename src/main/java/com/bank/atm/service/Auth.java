package com.bank.atm.service;

import com.bank.atm.model.Account;

public interface Auth {
    Account login(String nationalId, String password);

    void signUp(Account account);
}
