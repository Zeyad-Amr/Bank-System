package com.bank.atm.service;

import com.bank.atm.model.Account;

public class Transactions {

    public static String deposit(Account account, double amount, String description) {
        PersonalTransactions personal = new PersonalTransactions();
        VipTransactions vip = new VipTransactions();
        if (account.getInfo()) {
            return vip.deposit(account, amount, description);
        } else {
            return personal.deposit(account, amount, description);
        }

    }

    public static String withdraw(Account account, double amount, String description) {
        PersonalTransactions personal = new PersonalTransactions();
        VipTransactions vip = new VipTransactions();
        if (account.getInfo()) {
            return vip.withdraw(account, amount, description);
        } else {
            return personal.withdraw(account, amount, description);
        }
    }

    public static String transfer(Account account, double amount, String description, String payToID) {
        PersonalTransactions personal = new PersonalTransactions();
        VipTransactions vip = new VipTransactions();
        if (account.getInfo()) {
            return vip.transfer(account, amount, description, payToID);
        } else {
            return personal.transfer(account, amount, description, payToID);
        }
    }

    public static String credit(Account account, double amount, String description) {
        PersonalTransactions personal = new PersonalTransactions();
        VipTransactions vip = new VipTransactions();
        if (account.getInfo()) {
            return vip.credit(account, amount, description, "-");
        } else {
            return personal.credit(account, amount, description, "-");
        }
    }

}
