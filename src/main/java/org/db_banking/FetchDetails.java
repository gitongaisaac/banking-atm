package org.db_banking;

/* Class FetchDetails. Contains 8 methods each for fetching basic user details i.e.  account_no, account_pin,
 * account_balance, social security number, account_type, last_name, first_name, and phone_no. It inherits attributes
 * from the DbParamAccessors class. */
public class FetchDetails extends DbParamConnections {
    double account_balance;

    String ssn, account_type, last_name, first_name, phone_no;


    DbParamConnections dbParamConnections = new DbParamConnections() {
        @Override
        protected int dbIntConnection(String query, int condition, String label) {
            return super.dbIntConnection(query, condition, label);
        }
    };

    /* Fetch the said account pin and return it */
    public int fetchAccountPin(int account_no) {
        int account_pin;

        /* Fetch the account_pin which corresponds to the account_no entered. */
        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        String label = "account_pin";

        /* FetchDetails object */
        FetchDetails fetchDetails = new FetchDetails();
//        account_pin = fetchDetails.dbIntegerAccessor(query, account_no, label);
        account_pin = fetchDetails.dbIntConnection(query, account_no, label);

        return account_pin;
    }

    /* Fetch said Account Number and return */
    public int fetchAccountNo(int pin) {
        String query = "SELECT account_no FROM Account_info WHERE account_pin = ?";
        String label = "account_no";

        FetchDetails fetchDetails = new FetchDetails();
//        int account_no = fetchDetails.dbIntConnection(query, pin, label);

        return fetchDetails.dbIntConnection(query, pin, label);
    }

    /* Fetch said Account Balance and return it */
    public double fetchAccountBalance(int account_no) {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        String label = "total_balance";

        FetchDetails fetchDetails = new FetchDetails();
        this.account_balance = fetchDetails.dbDoubleConnection(query, account_no, label);

        return this.account_balance;
    }

    /* Fetch social security number and return it */
    public   String fetchSSN(int account_no) {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        String label = "SSN";

        FetchDetails fetchDetails = new FetchDetails();
        this.ssn = fetchDetails.dbStringIConnection(query, account_no, label);

        return this.ssn;
    }

    /* Fetch Account Type and return it */
    public String fetchAccountType(int account_no) {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        String label = "account_type";

        FetchDetails fetchDetails = new FetchDetails();
        this.account_type = fetchDetails.dbStringIConnection(query, account_no, label);

        return this.account_type;
    }

    /* Fetch Last Name and return it. Uses the fetchSSN method */
    public String fetchLastName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        FetchDetails fetchDetails = new FetchDetails();
        this.last_name = fetchDetails.dbStringConnection(query, condition, label);

        return this.last_name;
    }

    /* Fetch First Name and return it. Uses the fetchSSN method */
    public String fetchFirstName(int account_no) {
        String query, condition, label;

        String ssn = this.fetchSSN(account_no);

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        FetchDetails fetchDetails = new FetchDetails();
        this.first_name = fetchDetails.dbStringConnection(query, condition,label);

        return this.first_name;
    }

    /* Fetch Phone Number and return it. Uses the fetchSSN method */
    public String fetchPhoneNo(int account_no) {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        String ssn = this.fetchSSN(account_no);

        FetchDetails fetchDetails = new FetchDetails();
        this.phone_no = fetchDetails.dbStringConnection(query, condition, label);

        return this.phone_no;
    }

//    public static void main(String[] args) {
//        FetchDetails fetchDetails = new FetchDetails();
//        int account = fetchDetails.getAccountNo();
//        System.out.println(account);
//
//        fetchDetails.setAccountNo(123456789);
//        FetchDetails fetchDetails1 = new FetchDetails();
//        int account2 = fetchDetails.getAccountNo();
//        System.out.println("From get account " + account2);
//    }

}
