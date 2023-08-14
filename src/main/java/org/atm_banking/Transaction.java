package org.atm_banking;

import org.db_banking.Requests;

public class Transaction extends Requests {
    String trans_name, trans_ref, trans_date, trans_time, ssn, trans_party;

    int account_no;

    double trans_amt, trans_bal;   // Transaction_amount;

    public Transaction(int account_no, double trans_amt, double trans_bal, String trans_name, String trans_party) {
        this.account_no = account_no;
        this.trans_amt = trans_amt;
        this.trans_bal = trans_bal;
        this.trans_name = trans_name;
        this.trans_party = trans_party;

        REFGenerator refGenerator = new REFGenerator();
        Transaction transaction = new Transaction(account_no, trans_amt, trans_bal, trans_name, trans_party);

        this.trans_ref = refGenerator.refGenerator();
        this.ssn = transaction.fetchSSN(account_no);
    }

    public void transDate() {}

    public void transTime() {}

    public void createEntry() {
        Transaction transaction = new Transaction(this.account_no, this.trans_amt, this.trans_bal, this.trans_name, this.trans_party);
        transaction.addTransaction(this.trans_ref, this.trans_name, this.trans_amt, this.trans_bal, this.trans_date, this.trans_time, this.trans_party, this.account_no, this.ssn);
    }

    public static void main(String[] args) {

    }
}
