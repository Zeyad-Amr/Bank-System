package com.bank.atm;

import com.bank.atm.gui.LoginFrame;

public class App {
    public static void main(String[] args) {

        LoginFrame Login = new LoginFrame();
        // Connection con = DbConnection.getConnection();
        // if (con == null) {
        // System.out.println("Connection Failed");
        // } else {
        // System.out.println("Connection Success");
        // }

        // AccountDao accountDao = new AccountDaoImpl();
        // Scanner input = new Scanner(System.in);

        // System.out.println("1- Sign Up\n2- Log In");
        // int auth = input.nextInt();

        // if (auth == 1) {
        // // ************ Sign Up Function *************/
        // System.out.println("Welcom");
        // System.out.println("Enter your National ID");
        // input.nextLine();
        // String nationalId = input.nextLine();

        // System.out.println("Enter your Name");
        // String name = input.nextLine();
        // System.out.println("Enter your Password");
        // String password = input.nextLine();

        // Date birthday = new Date(100, 5, 2);
        // System.out.println("Enter your Phone");
        // String phone = input.nextLine();
        // System.out.println("Enter your Intial Balance");
        // double balance = input.nextDouble();
        // double creditBalance = balance * 0.8;
        // double creditBalanceLimit = balance * 0.8;
        // Date creditDate = new Date();
        // Date creditEndDate = new Date(new Date().getYear(), new Date().getMonth() +
        // 2, new Date().getDate());

        // Boolean status = true;
        // Boolean info;

        // System.out.println("if your Gender is Male enter 1 , if Female enter 0");
        // Boolean gender;
        // if (input.nextInt() == 1) {
        // gender = true;
        // } else {
        // gender = false;
        // }

        // if (balance >= 500000) {
        // info = true;
        // } else {
        // info = false;
        // }

        // Account account = new Account(0, name, nationalId, password, birthday, phone,
        // balance, creditBalance,
        // Utils.getRandomNumber(11111111, 99999999), creditBalanceLimit, creditDate,
        // creditEndDate, status,
        // gender, info);
        // AuthImpl.signUp(account);

        // System.out.println("********************* Your Data *********************");
        // System.out.println(accountDao.findByNationalId(nationalId).toString());

        // } else if (auth == 2) {
        // // ************ Login Function *************/
        // System.out.println("Enter your National ID");
        // input.nextLine();
        // String nationalId = input.nextLine();
        // System.out.println("Enter your Password");
        // String password = input.nextLine();
        // Account acc = AuthImpl.login(nationalId, password);
        // PersonalTransaction personalTransaction = new PersonalTransactionImpl();
        // personalTransaction.deposit(acc, 500, "description");
        // }

        // input.close();

        // System.out.println("Finished");
    }

}
