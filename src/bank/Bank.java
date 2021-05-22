
package bank;

import java.util.Scanner;

public class Bank {
/////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
    
        System.out.println("enter your name");
        
        Account user = new Account();
        user.setName(input.nextLine());
        System.out.println(user.getName());

    System.out.println("enter your ID");
 
        user.setNationalId(input.nextLine());
        System.out.println(user.getNationalId());
        input.close();
        
    System.out.println("enter your password");
 
        user.setPassword(input.nextLine());
        System.out.println(user.getPassword());
        input.close();

    System.out.println("enter your phone");
        
        user.setPhone(input.nextLine());
        System.out.println(user.getPhone());
        input.close();

    }

}
