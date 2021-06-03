package com.bank.atm.service;

import java.util.Date;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.AccountDaoImpl;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.dao.ProcessDaoImpl;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public class PersonalTransactionImpl implements PersonalTransaction {

    @Override
    public void deposit(Account account, double amount, String description) {
        ProcessDao processDao = new ProcessDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();

        // Add Process
        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount, "deposit",
                (account.getBalance() + amount), account.getCreditBalance(), new Date(), description, "-");

        processDao.save(cashProcess);

        // Update Account
        account = new Account(account.getId(), account.getName(), account.getNationalId(), account.getPassword(),
                account.getBirthday(), account.getPhone(), (account.getBalance() + amount), account.getCreditBalance(),
                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                account.getCreditEndDate(), account.getStatus(), account.getGender(), account.getInfo());

        accountDao.save(account);

    }

    @Override
    public void withdraw(Account account, double amount, String description) {
        ProcessDao processDao = new ProcessDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();

        // Add Process
        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount, "withdraw",
                (account.getBalance() - amount), account.getCreditBalance(), new Date(), description, "-");

        processDao.save(cashProcess);

        // Update Account
        account = new Account(account.getId(), account.getName(), account.getNationalId(), account.getPassword(),
                account.getBirthday(), account.getPhone(), (account.getBalance() - amount), account.getCreditBalance(),
                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                account.getCreditEndDate(), account.getStatus(), account.getGender(), account.getInfo());

        accountDao.save(account);
    }

    @Override
    public void transfer(Account account, double amount, String description, String payToID) {
        ProcessDao processDao = new ProcessDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();

        // Add process
        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount, "transfer",
                (account.getBalance() - amount), account.getCreditBalance(), new Date(), description, payToID);

        processDao.save(cashProcess);

        // Update Account
        account = new Account(account.getId(), account.getName(), account.getNationalId(), account.getPassword(),
                account.getBirthday(), account.getPhone(), (account.getBalance() - amount), account.getCreditBalance(),
                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                account.getCreditEndDate(), account.getStatus(), account.getGender(), account.getInfo());

        accountDao.save(account);

        // Transfer Money and Update transfer Account
        Account transferAccount = accountDao.findByNationalId(payToID);
        transferAccount = new Account(transferAccount.getId(), transferAccount.getName(),
                transferAccount.getNationalId(), transferAccount.getPassword(), transferAccount.getBirthday(),
                transferAccount.getPhone(), transferAccount.getBalance(), transferAccount.getCreditBalance(),
                transferAccount.getCreditCardNumber(), transferAccount.getCreditBalanceLimit(),
                transferAccount.getCreditDate(), transferAccount.getCreditEndDate(), transferAccount.getStatus(),
                transferAccount.getGender(), transferAccount.getInfo());

        accountDao.save(transferAccount);

    }

    @Override
    public void credit(Account account, double amount, String description, String paymentFor) {
        ProcessDao processDao = new ProcessDaoImpl();
        AccountDao accountDao = new AccountDaoImpl();

        // Add Process
        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount, "credit",
                (account.getBalance() - amount), account.getCreditBalance(), new Date(), description, paymentFor);

        processDao.save(cashProcess);

        // Update Account
        account = new Account(account.getId(), account.getName(), account.getNationalId(), account.getPassword(),
                account.getBirthday(), account.getPhone(), account.getBalance(), (account.getCreditBalance() - amount),
                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                account.getCreditEndDate(), account.getStatus(), account.getGender(), account.getInfo());

        accountDao.save(account);
    }

}
