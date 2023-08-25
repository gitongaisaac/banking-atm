package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Transfer extends Requests {
    final String trans_name = "Payment to";
    final String trans_name1 = "Payment from";

    String ssn, ssn1;

    double trans_amt, trans_bal, trans_bal1;

    int account_no, trans_party;

    public Transfer(int account_no) {
        this.account_no = account_no;

        this.ssn = fetchSSN(account_no);
    }

    public void enterDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Account No.: ");
        this.trans_party = scanner.nextInt();
        this.ssn1 = fetchSSN(trans_party);

        System.out.print("Amount: ");
        this.trans_amt = scanner.nextInt();
    }

    public void validation() {
        String party_ssn;
        party_ssn = fetchSSN(this.trans_party);

        System.out.println(party_ssn);
    }

    public void transfer() {
        enterDetails();

        withdrawBalance(this.account_no, this.trans_amt);
        depositBalance(this.trans_party, this.trans_amt);

        this.trans_bal = fetchAccountBalance(this.account_no);
        this.trans_bal1 = fetchAccountBalance(this.trans_party);

        Transaction transaction = new Transaction(trans_name, trans_amt, trans_bal, trans_party, account_no, ssn);
        transaction.addTransaction();

        Transaction transaction1 = new Transaction(trans_name1, trans_amt, trans_bal1, account_no, trans_party, ssn1);
        transaction1.addTransaction();
    }
}
