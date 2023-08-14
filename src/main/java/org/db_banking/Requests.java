package org.db_banking;

/* Class Requests. Contains 8 methods each for fetching basic user details i.e.  account_no, account_pin,
 * account_balance, social security number, account_type, last_name, first_name, and phone_no. It inherits attributes
 * from the DbParamAccessors class. */
public class Requests extends DbConnections {
    double account_balance;

    String ssn, account_type, last_name, first_name, phone_no, trans_party;

    /* Fetch the said account pin and return it */
    public int fetchAccountPin(int account_no) {
        int account_pin;

        /* Fetch the account_pin which corresponds to the account_no entered. */
        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        String label = "account_pin";

        /* Requests object */
        Requests requests = new Requests();
//        account_pin = requests.dbIntegerAccessor(query, account_no, label);
        account_pin = requests.dbIntConnection(query, account_no, label);

        return account_pin;
    }

    /* Fetch said Account Number and return */
    public int fetchAccountNo(int pin) {
        String query = "SELECT account_no FROM Account_info WHERE account_pin = ?";
        String label = "account_no";

        Requests requests = new Requests();
//        int account_no = requests.dbIntConnection(query, pin, label);

        return requests.dbIntConnection(query, pin, label);
    }

    /* Fetch said Account Balance and return it */
    public double fetchAccountBalance(int account_no) {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        String label = "total_balance";

        Requests requests = new Requests();
        this.account_balance = requests.dbDoubleConnection(query, account_no, label);

        return this.account_balance;
    }

    /* Fetch social security number and return it */
    public   String fetchSSN(int account_no) {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        String label = "SSN";

        Requests requests = new Requests();
        this.ssn = requests.dbStringConnection(query, account_no, label);

        return this.ssn;
    }

    /* Fetch Account Type and return it */
    public String fetchAccountType(int account_no) {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        String label = "account_type";

        Requests requests = new Requests();
        this.account_type = requests.dbStringConnection(query, account_no, label);

        return this.account_type;
    }

    /* Fetch Last Name and return it. Uses the fetchSSN method */
    public String fetchLastName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        Requests requests = new Requests();
        this.last_name = requests.dbStringConnection(query, condition, label);

        return this.last_name;
    }

    /* Fetch First Name and return it. Uses the fetchSSN method */
    public String fetchFirstName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        Requests requests = new Requests();
        this.first_name = requests.dbStringConnection(query, condition,label);

        return this.first_name;
    }

    /* Fetch Phone Number and return it. Uses the fetchSSN method */
    public String fetchPhoneNo(int account_no) {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        String ssn = this.fetchSSN(account_no);

        Requests requests = new Requests();
        this.phone_no = requests.dbStringConnection(query, condition, label);

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

        Requests requests = new Requests();
        requests.postDbDoubleConnection(query, account_no, amt);
    }

    public void withdrawBalance(int account_no, double amt) {
        String query = """
                UPDATE Account_info
                SET total_balance = total_balance - ?
                WHERE account_no = ?
                """;

        Requests requests = new Requests();
        requests.postDbDoubleConnection(query, account_no, amt);
    }

    public void addTransaction(String trans_ref, String trans_name, double trans_amt, double trans_bal, String trans_date,
                               String trans_time, String trans_party, int account_no, String ssn) {
        String query = """
                INSERT INTO Account_info (REF, trans_name, trans_amt, trans_bal, trans_date, trans_time, trans_party
                account_no, SSN)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        Requests requests = new Requests();
        requests.postTransactionInfo(query, trans_ref, trans_name, trans_amt, trans_bal, trans_date, trans_time, trans_party, account_no, ssn);
    }


//    public static void main(String[] args) {
//        Requests fetchDetails = new Requests();
//        int account = fetchDetails.getAccountNo();
//        System.out.println(account);
//
//        fetchDetails.setAccountNo(123456789);
//        Requests fetchDetails1 = new Requests();
//        int account2 = fetchDetails.getAccountNo();
//        System.out.println("From get account " + account2);
//    }

}
