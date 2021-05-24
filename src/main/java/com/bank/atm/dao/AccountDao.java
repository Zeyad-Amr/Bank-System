package com.bank.atm.dao;

import java.util.List;
import com.bank.atm.model.Account;

public interface AccountDao {
    List<Account> findAll();

    Account findByNationalId(String nationalId);

    void save(Account account);

}
