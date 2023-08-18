package org.atm_banking;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.db_banking.Requests;


public class Transaction extends Requests {
    String trans_name, trans_ref, ssn, trans_party;

    Date trans_date;

    Time trans_time;

    double trans_amt, trans_bal;   // Transaction_amount;

    int account_no;

    public Transaction(String trans_name, double trans_amt, double trans_bal, String trans_party, int account_no,
                       String ssn) {

        this.trans_name = trans_name;
        this.trans_amt = trans_amt;
        this.trans_bal = trans_bal;
        this.trans_party = trans_party;
        this.account_no = account_no;
        this.ssn = ssn;

//        LocalDateTime localDateTime = LocalDateTime.now();
//
//        DateTimeFormatter timeFormatted = DateTimeFormatter.ofPattern("HH:mm:ss");
//        this.trans_time = localDateTime.format(timeFormatted);
//
//        DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        this.trans_date = localDateTime.format(dateFormatted);

        this.trans_date = new Date(Calendar.getInstance().getTime().getTime());

        // Set event time
        this.trans_time = new Time(Calendar.getInstance().getTime().getTime());
    }

    public void addTransaction() {
        REFGenerator refGenerator = new REFGenerator();

        this.trans_ref = refGenerator.refGenerator();

        System.out.println(this.trans_ref);

        Transaction transaction = new Transaction(this.trans_name, this.trans_amt, this.trans_bal, this.trans_party,
                this.account_no, this.ssn);

        transaction.createTransaction(this.trans_ref, this.trans_name, this.trans_amt, this.trans_bal, this.trans_date,
                this.trans_time, this.trans_party, this.account_no, this.ssn);
    }
}
