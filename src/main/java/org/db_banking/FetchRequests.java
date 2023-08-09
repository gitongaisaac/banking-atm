package org.db_banking;

/* Class FetchRequests. Contains 8 methods each for fetching basic user details i.e.  account_no, account_pin,
 * account_balance, social security number, account_type, last_name, first_name, and phone_no. It inherits attributes
 * from the DbParamAccessors class. */
public class FetchRequests extends DbFetchConnections {
    double account_balance;

    String ssn, account_type, last_name, first_name, phone_no;

    /* Fetch the said account pin and return it */
    public int fetchAccountPin(int account_no) {
        int account_pin;

        /* Fetch the account_pin which corresponds to the account_no entered. */
        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        String label = "account_pin";

        /* FetchRequests object */
        FetchRequests fetchRequests = new FetchRequests();
//        account_pin = fetchRequests.dbIntegerAccessor(query, account_no, label);
        account_pin = fetchRequests.dbIntConnection(query, account_no, label);

        return account_pin;
    }

    /* Fetch said Account Number and return */
    public int fetchAccountNo(int pin) {
        String query = "SELECT account_no FROM Account_info WHERE account_pin = ?";
        String label = "account_no";

        FetchRequests fetchRequests = new FetchRequests();
//        int account_no = fetchRequests.dbIntConnection(query, pin, label);

        return fetchRequests.dbIntConnection(query, pin, label);
    }

    /* Fetch said Account Balance and return it */
    public double fetchAccountBalance(int account_no) {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        String label = "total_balance";

        FetchRequests fetchRequests = new FetchRequests();
        this.account_balance = fetchRequests.dbDoubleConnection(query, account_no, label);

        return this.account_balance;
    }

    /* Fetch social security number and return it */
    public   String fetchSSN(int account_no) {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        String label = "SSN";

        FetchRequests fetchRequests = new FetchRequests();
        this.ssn = fetchRequests.dbStringIConnection(query, account_no, label);

        return this.ssn;
    }

    /* Fetch Account Type and return it */
    public String fetchAccountType(int account_no) {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        String label = "account_type";

        FetchRequests fetchRequests = new FetchRequests();
        this.account_type = fetchRequests.dbStringIConnection(query, account_no, label);

        return this.account_type;
    }

    /* Fetch Last Name and return it. Uses the fetchSSN method */
    public String fetchLastName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        FetchRequests fetchRequests = new FetchRequests();
        this.last_name = fetchRequests.dbStringConnection(query, condition, label);

        return this.last_name;
    }

    /* Fetch First Name and return it. Uses the fetchSSN method */
    public String fetchFirstName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        FetchRequests fetchRequests = new FetchRequests();
        this.first_name = fetchRequests.dbStringConnection(query, condition,label);

        return this.first_name;
    }

    /* Fetch Phone Number and return it. Uses the fetchSSN method */
    public String fetchPhoneNo(int account_no) {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        String ssn = this.fetchSSN(account_no);

        FetchRequests fetchRequests = new FetchRequests();
        this.phone_no = fetchRequests.dbStringConnection(query, condition, label);

        return this.phone_no;
    }

//    public static void main(String[] args) {
//        FetchRequests fetchDetails = new FetchRequests();
//        int account = fetchDetails.getAccountNo();
//        System.out.println(account);
//
//        fetchDetails.setAccountNo(123456789);
//        FetchRequests fetchDetails1 = new FetchRequests();
//        int account2 = fetchDetails.getAccountNo();
//        System.out.println("From get account " + account2);
//    }

}
