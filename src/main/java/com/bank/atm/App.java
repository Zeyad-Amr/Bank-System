package com.bank.atm;

import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;

import com.bank.atm.dao.AccountDao;
import com.bank.atm.dao.AccountDaoImpl;
import com.bank.atm.dao.DbConnection;
import com.bank.atm.dao.ProcessDao;
import com.bank.atm.dao.ProcessDaoImpl;
import com.bank.atm.model.Account;
import com.bank.atm.model.CashProcess;

public class App {
    public static void main(String[] args) {
        String nationalId = "0";
        Connection con = DbConnection.getConnection();
        if (con == null) {
            System.out.println("Connection Failed");
        } else {
            System.out.println("Connection Success");
        }
        AccountDao accountDao = new AccountDaoImpl();
        Scanner input = new Scanner(System.in);

        System.out.println("1- Sign Up\n2- Log In");
        int auth = input.nextInt();

        if (auth == 1) {
            System.out.println("Welcom");
            System.out.println("Enter your National ID");
            input.nextLine();
            nationalId = input.nextLine();
            System.out.println("Enter your Name");
            String name = input.nextLine();
            System.out.println("Enter your Password");
            String password = input.nextLine();

            Date birthday = new Date(100, 5, 2);
            System.out.println("Enter your Phone");
            String phone = input.nextLine();
            System.out.println("Enter your Intial Balance");
            double balance = input.nextDouble();
            double creditBalance = balance * 0.8;
            Date creditDate = new Date();
            Date creditEndDate = new Date(new Date().getYear(), new Date().getMonth() + 2, new Date().getDate());
            ;
            Boolean status = true;
            System.out.println("if your Gender is Male enter 1 , if Female enter 0");
            Boolean gender;
            if (input.nextInt() == 1) {
                gender = true;
            } else {
                gender = false;
            }
            Account account = new Account(0, name, nationalId, password, birthday, phone, balance, creditBalance,
                    creditDate, creditEndDate, status, gender);
            accountDao.save(account);
            System.out.println("********************* Your Data *********************");
            System.out.println(accountDao.findByNationalId(nationalId).toString());
        } else if (auth == 2) {
            System.out.println("Login :)");

        }

        input.close();
        System.out.println("Finished");
    }

}
