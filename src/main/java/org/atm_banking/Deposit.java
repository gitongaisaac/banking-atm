package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Deposit extends Requests {
    // trans = transaction, amt = amount, bal = balance
    final String trans_name = "Deposit";

    String ssn;

    double trans_amt, trans_bal;

    int account_no, trans_party;

    public Deposit(int account_no) {
        this.account_no = account_no;

        this.ssn = fetchSSN(this.account_no);

        this.trans_party = this.account_no;
    }

    public static double enterAmt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How much do you wish to deposit?");
        System.out.print("Amount: $");

        return scanner.nextDouble();
    }

    public void deposit() {
        Deposit deposit = new Deposit(this.account_no);
        this.trans_amt = enterAmt();

        deposit.depositBalance(this.account_no, this.trans_amt);

        this.trans_bal = deposit.fetchAccountBalance(this.account_no);

        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.trans_party,
                this.account_no, this.ssn);
        transaction.addTransaction();
    }
}
