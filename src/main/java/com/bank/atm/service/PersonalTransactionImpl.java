package com.bank.atm.service;

import java.time.LocalDate;
import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public class PersonalTransactionImpl implements PersonalTransaction {

        @Override
        public void deposit(Account account, double amount, String description) {

                // Add Process
                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                "deposit", (account.getBalance() + amount), account.getCreditBalance(), LocalDate.now(),
                                description, "-");

                ProcessDao.save(cashProcess);

                // Update Account Data
                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                (account.getBalance() + amount), account.getCreditBalance(),
                                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                                account.getCreditEndDate(), account.getStatus(), account.getGender(),
                                account.getInfo());

                AccountDao.save(account);

        }

        @Override
        public void withdraw(Account account, double amount, String description) {

                // Add Process
                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                "withdraw", (account.getBalance() - amount), account.getCreditBalance(),
                                LocalDate.now(), description, "-");

                ProcessDao.save(cashProcess);

                // Update Account Data
                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                (account.getBalance() - amount), account.getCreditBalance(),
                                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                                account.getCreditEndDate(), account.getStatus(), account.getGender(),
                                account.getInfo());

                AccountDao.save(account);
        }

        @Override
        public void transfer(Account account, double amount, String description, String payToID) {

                // Add process
                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                "transfer", (account.getBalance() - amount), account.getCreditBalance(),
                                LocalDate.now(), description, payToID);

                ProcessDao.save(cashProcess);

                // Update Account Data
                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                (account.getBalance() - amount), account.getCreditBalance(),
                                account.getCreditCardNumber(), account.getCreditBalanceLimit(), account.getCreditDate(),
                                account.getCreditEndDate(), account.getStatus(), account.getGender(),
                                account.getInfo());

                AccountDao.save(account);

                // Transfer Money and Update transfer Account
                Account transferAccount = AccountDao.findByNationalId(payToID);
                transferAccount = new Account(transferAccount.getId(), transferAccount.getName(),
                                transferAccount.getNationalId(), transferAccount.getPassword(),
                                transferAccount.getBirthday(), transferAccount.getPhone(), transferAccount.getBalance(),
                                transferAccount.getCreditBalance(), transferAccount.getCreditCardNumber(),
                                transferAccount.getCreditBalanceLimit(), transferAccount.getCreditDate(),
                                transferAccount.getCreditEndDate(), transferAccount.getStatus(),
                                transferAccount.getGender(), transferAccount.getInfo());

                AccountDao.save(transferAccount);

        }

        @Override
        public void credit(Account account, double amount, String description, String paymentFor) {

                // Add Process
                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                "credit", (account.getBalance() - amount), account.getCreditBalance(), LocalDate.now(),
                                description, paymentFor);

                ProcessDao.save(cashProcess);

                // Update Account
                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                account.getPassword(), account.getBirthday(), account.getPhone(), account.getBalance(),
                                (account.getCreditBalance() - amount), account.getCreditCardNumber(),
                                account.getCreditBalanceLimit(), account.getCreditDate(), account.getCreditEndDate(),
                                account.getStatus(), account.getGender(), account.getInfo());

                AccountDao.save(account);
        }

}
