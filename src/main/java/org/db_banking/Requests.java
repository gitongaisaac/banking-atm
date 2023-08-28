package org.db_banking;

import java.sql.Date;
import java.sql.Time;

public abstract class Requests extends DbConnections {
    double account_balance;

    String ssn, account_type, last_name, first_name, phone_no;

    public int fetchAccountPin(int account_no) {
        int account_pin;

        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        String label = "account_pin";

        /* Requests object */
//        account_pin = dbIntegerAccessor(query, account_no, label);
        account_pin = dbIntConnection(query, account_no, label);

        return account_pin;
    }

    /* Fetch said Account Number and return */
    public int fetchAccountNo(int pin) {
        String query = "SELECT account_no FROM Account_info WHERE account_pin = ?";
        String label = "account_no";

//        int account_no = requests.dbIntConnection(query, pin, label);

        return dbIntConnection(query, pin, label);
    }

    public double fetchAccountBalance(int account_no) {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        String label = "total_balance";

        this.account_balance = dbDoubleConnection(query, account_no, label);

        return this.account_balance;
    }

    public   String fetchSSN(int account_no) {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        String label = "SSN";

        this.ssn = dbStringConnection(query, account_no, label);

        return this.ssn;
    }

    public String fetchAccountType(int account_no) {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        String label = "account_type";

        this.account_type = dbStringConnection(query, account_no, label);

        return this.account_type;
    }

    public String fetchLastName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        this.last_name = dbStringConnection(query, condition, label);

        return this.last_name;
    }

    public String fetchFirstName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        this.first_name = dbStringConnection(query, condition,label);

        return this.first_name;
    }

    /* Fetch Phone Number and return it. Uses the fetchSSN method */
    public String fetchPhoneNo(int account_no) {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        String ssn = this.fetchSSN(account_no);

        this.phone_no = dbStringConnection(query, condition, label);

        return this.phone_no;
    }

/*
 * Post Requests
 */

    public void depositBalance(int account_no, double amt) {
        String query = """
                UPDATE Account_info
                SET total_balance = total_balance + ?
                WHERE account_no = ?
                """;

        postDbDoubleConnection(query, account_no, amt);
    }

    public void withdrawBalance(int account_no, double amt) {
        String query = """
                UPDATE Account_info
                SET total_balance = total_balance - ?
                WHERE account_no = ?
                """;

        postDbDoubleConnection(query, account_no, amt);
    }

    public void createTransaction(String trans_ref, String trans_name, double trans_amt, double trans_bal,
                                  Date trans_date, Time trans_time, int trans_party, int account_no, String ssn) {
        String query = """
                INSERT INTO `atm_banking`.`Trans_info`
                (`REF`, `trans_name`, `trans_amt`, `trans_bal`, `trans_date`, `trans_time`, `trans_party`, `account_no`,
                    `SSN`)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        postTransactionInfo(query, trans_ref, trans_name, trans_amt, trans_bal, trans_date, trans_time,
                trans_party, account_no, ssn);
    }
}
