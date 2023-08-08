package org.atm_banking;

import org.db_banking.FetchDetails;

import java.util.Scanner;

/* Deposit class. Takes care of transactions concerning depositing of cash. Has one method deposit() */
public class Deposit extends FetchDetails {

    int account_no;

    double account_bal;

    public double getAmt() {
        double amt;

        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to deposit?");
        System.out.print("Amount: $");
        amt = scanner.nextDouble();

        return amt;
    }

    /* Total amount in the account */
    public static void deposit(int account_no) {
        Deposit deposit = new Deposit();
        double amt = deposit.getAmt();
        double balance = deposit.fetchAccountBalance(account_no);



        System.out.println("Account Balance: $" + balance);
    }
}
