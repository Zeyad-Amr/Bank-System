package com.bank.atm.service;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public class VipTransactions extends PersonalTransactions {
        JFrame jFrame = new JFrame("Bankoo Account");

        @Override
        public String deposit(Account account, double amount, String description) {

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
                return "1";

        }

        @Override
        public String withdraw(Account account, double amount, String description) {
                if (amount > 20000) {
                        JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                } else {
                        // Add Process
                        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                        "withdraw", (account.getBalance() - amount), account.getCreditBalance(),
                                        LocalDate.now(), description, "-");

                        ProcessDao.save(cashProcess);

                        // Update Account Data
                        account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                        account.getPassword(), account.getBirthday(), account.getPhone(),
                                        (account.getBalance() - amount), account.getCreditBalance(),
                                        account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                        account.getCreditDate(), account.getCreditEndDate(), account.getStatus(),
                                        account.getGender(), account.getInfo());

                        AccountDao.save(account);
                }
                return "1";
        }

        @Override
        public String transfer(Account account, double amount, String description, String payToID) {
                if (amount > 20000) {
                        JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                } else {
                        // Add process
                        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                        "transfer", (account.getBalance() - amount), account.getCreditBalance(),
                                        LocalDate.now(), description, payToID);

                        ProcessDao.save(cashProcess);

                        // Update Account Data
                        account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                        account.getPassword(), account.getBirthday(), account.getPhone(),
                                        (account.getBalance() - amount), account.getCreditBalance(),
                                        account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                        account.getCreditDate(), account.getCreditEndDate(), account.getStatus(),
                                        account.getGender(), account.getInfo());

                        AccountDao.save(account);

                        // Transfer Money and Update transfer Account
                        Account transferAccount = AccountDao.findByNationalId(payToID);
                        transferAccount = new Account(transferAccount.getId(), transferAccount.getName(),
                                        transferAccount.getNationalId(), transferAccount.getPassword(),
                                        transferAccount.getBirthday(), transferAccount.getPhone(),
                                        transferAccount.getBalance(), transferAccount.getCreditBalance(),
                                        transferAccount.getCreditCardNumber(), transferAccount.getCreditBalanceLimit(),
                                        transferAccount.getCreditDate(), transferAccount.getCreditEndDate(),
                                        transferAccount.getStatus(), transferAccount.getGender(),
                                        transferAccount.getInfo());

                        AccountDao.save(transferAccount);
                }
                return "1";
        }

        @Override
        public String credit(Account account, double amount, String description, String paymentFor) {
                if (amount > 20000) {
                        JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                        return "0";
                } else {
                        // Add Process
                        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                        "credit", account.getBalance(), (account.getCreditBalance() - amount),
                                        LocalDate.now(), description, paymentFor);

                        ProcessDao.save(cashProcess);

                        // Update Account
                        account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                        account.getPassword(), account.getBirthday(), account.getPhone(),
                                        account.getBalance(), (account.getCreditBalance() - amount),
                                        account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                        account.getCreditDate(), account.getCreditEndDate(), account.getStatus(),
                                        account.getGender(), account.getInfo());

                        AccountDao.save(account);
                        return "1";
                }
        }

}
