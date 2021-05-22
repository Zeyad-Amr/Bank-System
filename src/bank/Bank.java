
package bank;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        // fun(3);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name");
        Account user = new Account();
        user.setName(input.nextLine());
        System.out.println(user.getName());
        input.close();
    }

    // public static void fun(int x) {
    // if (x > 0) {
    // fun(--x);
    // System.out.println("Hello " + x);
    // }
    // }

}
