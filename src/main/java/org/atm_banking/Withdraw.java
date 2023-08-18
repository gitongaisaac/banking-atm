package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Withdraw extends Requests {
// trans = transaction, amt = amount, bal = balance
    String trans_name = "Withdraw";

    String ssn, trans_party;

    double trans_amt, trans_bal;

    int account_no;

    public Withdraw(int account_no) {
        this.account_no = account_no;

        this.ssn = fetchSSN(this.account_no);

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

        withdraw.withdrawBalance(this.account_no, this.trans_amt);

        this.trans_bal = withdraw.fetchAccountBalance(this.account_no);

        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.ssn,
                this.account_no, this.ssn);

        transaction.addTransaction();
    }
}
