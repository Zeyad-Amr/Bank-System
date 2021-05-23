
package bank;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
Account user = new Account();
Scanner input = new Scanner(System.in);

    System.out.println("enter your name");
        user.setName(input.nextLine());
        System.out.println(user.getName());

    System.out.println("enter your ID");
        user.setNationalId(input.nextLine());
        System.out.println(user.getNationalId());
        
    System.out.println("enter your password");
        user.setPassword(input.nextLine());
        System.out.println(user.getPassword());

    System.out.println("enter your phone");
        user.setPhone(input.nextLine());
        System.out.println(user.getPhone());

    System.out.println("enter your birth date");
        user.setBirthDate(input.nextLine());
        System.out.println(user.getBirthDate());

    System.out.println("enter your balance");
        user.setBalance(input.nextFloat());
        System.out.println(user.getBalance());
        user.status();

    System.out.println("enter your credit balance");
        user.setCreditBalance(input.nextFloat());
        System.out.println(user.getCreditBalance());

    System.out.println("enter your credit date");
        user.setCreditDate(input.nextLine());
        System.out.println(user.getCreditDate());

    System.out.println("enter your credit end date");
        user.setCreditEndDate(input.nextLine());
        System.out.println(user.getCreditEndDate());
        input.close();
    }

    

}