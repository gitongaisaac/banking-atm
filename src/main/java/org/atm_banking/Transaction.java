package org.atm_banking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.db_banking.Requests;


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

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter timeFormatted = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.trans_time =localDateTime.format(timeFormatted);

        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.trans_date = localDateTime.format(dateFormatted);
    }

    public void addTransaction() {
        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.trans_party,
                this.account_no, this.ssn);
        transaction.createTransaction(this.trans_ref, this.trans_name, this.trans_amt, this.trans_bal, this.trans_date,
                this.trans_time, this.trans_party, this.account_no, this.ssn);
    }
}
