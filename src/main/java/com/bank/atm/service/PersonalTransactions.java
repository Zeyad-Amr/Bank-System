package com.bank.atm.service;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public class PersonalTransactions {
        JFrame jFrame = new JFrame("Bankoo Account");

        public String deposit(Account account, double amount, String description) {

                try {
                        // Add Process
                        CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(), amount,
                                        "deposit", (account.getBalance() + amount), account.getCreditBalance(),
                                        LocalDate.now(), description, "-");

                        ProcessDao.save(cashProcess);

                        // Update Account Data
                        account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                        account.getPassword(), account.getBirthday(), account.getPhone(),
                                        (account.getBalance() + amount), account.getCreditBalance(),
                                        account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                        account.getCreditDate(), account.getCreditEndDate(), account.getStatus(),
                                        account.getGender(), account.getInfo());

                        AccountDao.save(account);
                        return "1";
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jFrame, "Something is wrong, please try again");
                        return "0";
                }

        }

        public String withdraw(Account account, double amount, String description) {
                try {
                        Double expenses = Services.getTotalWithdrawToday(account)
                                        + Services.getTotalTransferToday(account);
                        if (amount > 2000) {
                                JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                                return "0";
                        } else if (account.getBalance() < amount) {
                                JOptionPane.showMessageDialog(jFrame, "Your balance isn't sufficient");
                                return "0";
                        } else if (amount > (8000 - expenses)) {
                                JOptionPane.showMessageDialog(jFrame, "Your daily cash withdrawal is " + expenses
                                                + " EGP, Only " + (8000 - expenses) + " EGP allowed");
                                return "0";
                        } else {
                                // Add Process
                                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(),
                                                amount, "withdraw", (account.getBalance() - amount),
                                                account.getCreditBalance(), LocalDate.now(), description, "-");

                                ProcessDao.save(cashProcess);

                                // Update Account Data
                                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                                (account.getBalance() - amount), account.getCreditBalance(),
                                                account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                                account.getCreditDate(), account.getCreditEndDate(),
                                                account.getStatus(), account.getGender(), account.getInfo());

                                AccountDao.save(account);
                                return "1";
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jFrame, "Something is wrong, please try again");
                        return "0";
                }

        }

        public String transfer(Account account, double amount, String description, String payToID) {
                try {
                        Double expenses = Services.getTotalWithdrawToday(account)
                                        + Services.getTotalTransferToday(account);
                        if (amount > 2000) {
                                JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                                return "0";
                        } else if (account.getBalance() < amount) {
                                JOptionPane.showMessageDialog(jFrame, "Your balance isn't sufficient");
                                return "0";
                        } else if (amount > (8000 - expenses)) {
                                JOptionPane.showMessageDialog(jFrame, "Your daily cash withdrawal is " + expenses
                                                + " EGP, Only " + (8000 - expenses) + " EGP allowed");
                                return "0";
                        } else {
                                // Add process
                                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(),
                                                amount, "transfer", (account.getBalance() - amount),
                                                account.getCreditBalance(), LocalDate.now(), description, payToID);

                                ProcessDao.save(cashProcess);

                                // Update Account Data
                                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                                (account.getBalance() - amount), account.getCreditBalance(),
                                                account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                                account.getCreditDate(), account.getCreditEndDate(),
                                                account.getStatus(), account.getGender(), account.getInfo());

                                AccountDao.save(account);

                                // Transfer Money and Update transfer Account

                                // Add process of transfer
                                Account transferAccount = AccountDao.findByNationalId(payToID);
                                CashProcess transferProcess = new CashProcess(0, transferAccount.getName(),
                                                transferAccount.getNationalId(), amount, "transfered to you",
                                                (transferAccount.getBalance() + amount), account.getCreditBalance(),
                                                LocalDate.now(),
                                                "This amount transfered from " + transferAccount.getName(), payToID);
                                ProcessDao.save(transferProcess);

                                // Update Account Transfer Data
                                transferAccount = new Account(transferAccount.getId(), transferAccount.getName(),
                                                transferAccount.getNationalId(), transferAccount.getPassword(),
                                                transferAccount.getBirthday(), transferAccount.getPhone(),
                                                (transferAccount.getBalance() + amount),
                                                transferAccount.getCreditBalance(),
                                                transferAccount.getCreditCardNumber(),
                                                transferAccount.getCreditBalanceLimit(),
                                                transferAccount.getCreditDate(), transferAccount.getCreditEndDate(),
                                                transferAccount.getStatus(), transferAccount.getGender(),
                                                transferAccount.getInfo());

                                AccountDao.save(transferAccount);

                                return "1";
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jFrame, "Something is wrong, please try again");
                        return "0";
                }

        }

        public String credit(Account account, double amount, String description, String paymentFor) {
                try {

                        Double expenses = Services.getTotalCreditToday(account);
                        if (amount > 2000) {
                                JOptionPane.showMessageDialog(jFrame, "Maximum amount allowed is 2000 EGP");
                                return "0";
                        } else if (account.getCreditBalance() < amount) {
                                JOptionPane.showMessageDialog(jFrame, "Your credit balance isn't sufficient");
                                return "0";
                        } else if (amount > (8000 - expenses)) {
                                JOptionPane.showMessageDialog(jFrame, "Your daily credit payments is " + expenses
                                                + " EGP, Only " + (8000 - expenses) + " EGP allowed");
                                return "0";
                        } else {
                                // Add Process
                                CashProcess cashProcess = new CashProcess(0, account.getName(), account.getNationalId(),
                                                amount, "credit", account.getBalance(),
                                                (account.getCreditBalance() - amount), LocalDate.now(), description,
                                                paymentFor);

                                ProcessDao.save(cashProcess);

                                // Update Account
                                account = new Account(account.getId(), account.getName(), account.getNationalId(),
                                                account.getPassword(), account.getBirthday(), account.getPhone(),
                                                account.getBalance(), (account.getCreditBalance() - amount),
                                                account.getCreditCardNumber(), account.getCreditBalanceLimit(),
                                                account.getCreditDate(), account.getCreditEndDate(),
                                                account.getStatus(), account.getGender(), account.getInfo());

                                AccountDao.save(account);
                                return "1";
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(jFrame, "Something is wrong, please try again");
                        return "0";
                }

        }

}
