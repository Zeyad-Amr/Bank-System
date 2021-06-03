package com.bank.atm.service;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.AccountDaoImpl;
import com.bank.atm.model.Account;

public class AuthImpl implements Auth {

    @Override
    public Account login(String nationalId, String password) {
        AccountDao accountDao = new AccountDaoImpl();
        if (accountDao.findByNationalId(nationalId) != null
                && accountDao.findByNationalId(nationalId).getPassword().equals(password)) {
            System.out.println("Login Successfully :)");
            System.out.println(accountDao.findByNationalId(nationalId));
        } else if (accountDao.findByNationalId(nationalId) == null) {
            System.out.println("This National ID hasn't account yet, Please Sign Up");
        } else if (!accountDao.findByNationalId(nationalId).getPassword().equals(password)) {
            System.out.println("Your password is wrong try again");

        } else {
            System.out.println("Something wrong try again");
        }
        return accountDao.findByNationalId(nationalId);
    }

    @Override
    public void signUp(Account account) {
        AccountDao accountDao = new AccountDaoImpl();
        if (accountDao.findByNationalId(account.getNationalId()) == null) {
            accountDao.save(account);
            System.out.println("Sign Up Successfully :)");
        } else {
            System.out.println("This National ID already used !!");
        }

    }

}
