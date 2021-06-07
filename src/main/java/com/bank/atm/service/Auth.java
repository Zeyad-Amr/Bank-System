package com.bank.atm.service;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.bank.atm.dao.AccountDao;
import com.bank.atm.model.Account;

public class Auth {

    public static Account login(String nationalId, String password) {
        JFrame jFrame = new JFrame("Bankoo Account");

        Account account = AccountDao.findByNationalId(nationalId);

        if (account != null && AccountDao.findByNationalId(nationalId).getPassword().equals(password)) {

            System.out.println("Login Successfully :)");
            System.out.println(account.toString());

            return account;
        } else if (account == null) {
            JOptionPane.showMessageDialog(jFrame, "This National ID hasn't any accounts yet, please Sign Up");
        } else if (!account.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(jFrame, "Your password is wrong, please try again");
        } else {
            JOptionPane.showMessageDialog(jFrame, "Please Enter Valid National ID and Password");
        }
        return null;
    }

    public static Account signUp(Account account) {
        JFrame jFrame = new JFrame("Bankoo Account");
        if (AccountDao.findByNationalId(account.getNationalId()) == null) {
            AccountDao.save(account);
            System.out.println("Sign Up Successfully :)");
            return account;
        } else {
            JOptionPane.showMessageDialog(jFrame, "This National ID already have an account");

        }
        return null;

    }

}
