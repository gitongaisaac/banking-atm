package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Withdraw extends Requests {
    String trans_name = "Withdraw"; // Transaction_name

    String ssn, trans_party;

    double trans_amt, trans_bal;   // Transaction_amount;

    int account_no;

    public Withdraw(int account_no) {
        this.account_no = account_no;

        Withdraw withdraw = new Withdraw(this.account_no);

        this.ssn = withdraw.fetchSSN(this.account_no);

        this.trans_party = this.ssn;
    }

    public static double enterAmt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to withdraw?");
        System.out.print("Amount: $");

        return scanner.nextDouble();
    }

    public void withdraw () {
        Withdraw withdraw = new Withdraw(this.account_no);

        this.trans_amt = enterAmt();
        this.trans_bal = withdraw.fetchAccountBalance(this.account_no);
        System.out.println("Account Balance: $" + this.trans_bal);

        withdraw.withdrawBalance(this.account_no, this.trans_amt);

        this.trans_bal = withdraw.fetchAccountBalance(this.account_no);
        System.out.println("New account balance: $" + this.trans_bal);

        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.trans_party, this.account_no, this.ssn);
        transaction.addTransaction();
    }
}
