package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

/* Deposit class. Takes care of transactions concerning depositing of cash. Has one method deposit() */
public class Deposit extends Requests {
    final String trans_name = "Deposit";  // Transaction_name

    String ref, trans_date, trans_time, ssn, trans_party;

    int account_no;

    double trans_amt;   // Transaction_amount;

    double trans_bal;   // Transaction_balance

    public Deposit() {
        REFGenerator refGenerator = new REFGenerator();
        Deposit deposit = new Deposit();

        this.ref = refGenerator.refGenerator();

        this.ssn = deposit.fetchSSN(this.account_no);

        this.trans_party = this.ssn;
    }

    public double getTransAmt() {
        return this.trans_amt;
    }

    public static double enterAmt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to deposit?");
        System.out.print("Amount: $");

        return scanner.nextDouble();
    }

    /* Total amount in the account */
    public void deposit(int account_no) {
        this.account_no = account_no;

        Deposit deposit = new Deposit();
        this.trans_amt = enterAmt();

        this.trans_bal = deposit.fetchAccountBalance(account_no);
        System.out.println("Account Balance: $" + this.trans_bal);

        deposit.depositBalance(account_no, this.trans_amt);

        this.trans_bal = deposit.fetchAccountBalance(account_no);
        System.out.println("\nNew Account Balance: $" + this.trans_bal);
    }
}
