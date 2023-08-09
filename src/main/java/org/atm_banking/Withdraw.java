package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Withdraw extends Requests {

    public static double getAmt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to withdraw?");
        System.out.print("Amount: $");

        return scanner.nextDouble();
    }

    public static void withdraw (int account_no) {
        Withdraw withdraw = new Withdraw();

        double amt = getAmt();
        double balance = withdraw.fetchAccountBalance(account_no);
        System.out.println("Account Balance: $" + balance);

        withdraw.withdrawBalance(account_no, amt);

        balance = withdraw.fetchAccountBalance(account_no);
        System.out.println("New account balance: $" + balance);
    }
}
