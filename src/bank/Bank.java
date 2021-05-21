
package bank;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Account user = new Account();
        user.setName(input.nextLine());
        System.out.println(user.getNamee());
        input.close();
    }

}
