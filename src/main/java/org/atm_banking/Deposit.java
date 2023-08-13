package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

/* Deposit class. Takes care of transactions concerning depositing of cash. Has one method deposit() */
public class Deposit extends Requests {
    double amt;

    public double getAmt() {
        return this.amt;
    }

    public static double enterAmt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to deposit?");
        System.out.print("Amount: $");

        return scanner.nextDouble();
    }

    /* Total amount in the account */
    public void deposit(int account_no) {
        Deposit deposit = new Deposit();
        this.amt = enterAmt();

        double balance = deposit.fetchAccountBalance(account_no);
        System.out.println("Account Balance: $" + balance);

        deposit.depositBalance(account_no, amt);

        balance = deposit.fetchAccountBalance(account_no);
        System.out.println("\nNew Account Balance: $" + balance);
    }
}
