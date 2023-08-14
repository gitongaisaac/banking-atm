package org.atm_banking;

import org.db_banking.Requests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction extends Requests {
    String trans_name, trans_ref, trans_date, trans_time, ssn, trans_party;

    double trans_amt, trans_bal;   // Transaction_amount;

    int account_no;

    public Transaction(String trans_name, double trans_amt, double trans_bal, String trans_party, int account_no,
                       String ssn) {
        REFGenerator refGenerator = new REFGenerator();

        this.trans_ref = refGenerator.refGenerator();

        this.trans_name = trans_name;
        this.trans_amt = trans_amt;
        this.trans_bal = trans_bal;
        this.trans_party = trans_party;
        this.account_no = account_no;
        this.ssn = ssn;
    }

    public void transDate() {

    }

    public void transTime() {}

    public void addTransaction() {
        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.trans_party,
                this.account_no, this.ssn);
        transaction.createTransaction(this.trans_ref, this.trans_name, this.trans_amt, this.trans_bal, this.trans_date,
                this.trans_time, this.trans_party, this.account_no, this.ssn);
    }
}
