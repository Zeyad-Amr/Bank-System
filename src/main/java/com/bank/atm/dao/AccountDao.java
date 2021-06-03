package com.bank.atm.dao;

import com.bank.atm.model.Account;

public interface AccountDao {

    Account findByNationalId(String nationalId);

    void save(Account account);

}
