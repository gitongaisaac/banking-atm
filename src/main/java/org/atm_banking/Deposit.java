package org.atm_banking;

import java.util.Scanner;

/* Deposit class. Takes care of transactions concerning depositing of cash. Has one method deposit() */
public class Deposit {

    /* Total amount in the account */
    int amountInTheAccount = 50000;

    public static int deposit(int amountInTheAccount){
        /*int amountInTheAccount = 50000;*/
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you wish to deposit: ");
        int amountDeposited = scanner.nextInt();
        int totalAmount = amountInTheAccount + amountDeposited;

        System.out.println("your account balance is " + totalAmount);

        return totalAmount;
    }

    public static void main(String[] args) {
        deposit(50000);
    }
}
