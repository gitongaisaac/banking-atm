package org.db_banking;

import org.atm_banking.SignIn;

public class FetchDetails extends DbParamAccessors {
    public int account_no;

    double total_balance;

    String ssn, account_type, last_name, first_name, phone_no;

    public void setAccountNo(int account_no) {
        this.account_no = account_no;
    }

    public int fetchAccountPin(int account_no) {
        int account_pin;

        /* Fetch the account_pin which corresponds to the account_no entered. Uses the DbParamAccessors class to fetch. */
        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        String label = "account_pin";

        FetchDetails fetchDetails = new FetchDetails();
        account_pin = fetchDetails.dbIntegerAccessor(query, account_no, label);

        return account_pin;
    }

    public void fetchAccountNo(int pin) {
        String query = "SELECT account_no FROM Account_info WHERE account_pin = ?";
        String label = "account_no";

        FetchDetails fetchDetails = new FetchDetails();
        this.account_no = fetchDetails.dbIntegerAccessor(query, pin, label);
    }

    public double fetchTotalBalance() {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "total_balance";

        FetchDetails fetchDetails = new FetchDetails();
        this.total_balance = fetchDetails.dbDoubleAccessor(query, condition, label);

        return this.total_balance;
    }

    public   String fetchSSN() {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "SSN";

        FetchDetails fetchDetails = new FetchDetails();
        this.ssn = fetchDetails.dbStringIAccessor(query, condition, label);

        return this.ssn;
    }

    public String fetchAccountType() {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "account_type";

        FetchDetails fetchDetails = new FetchDetails();
        this.account_type = fetchDetails.dbStringIAccessor(query, condition, label);

        return this.account_type;
    }

    public String fetchLastName() {
        String query, condition, label;

//        FetchDetails fetchDetails = new FetchDetails();
//        String ssn = fetchDetails.fetchSSN();
        String ssn = this.fetchSSN();

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        FetchDetails fetchDetails = new FetchDetails();
        this.last_name = fetchDetails.dbStringAccessor(query, condition, label);

        return this.last_name;
    }

    public String fetchFirstName() {
        String query, condition, label;

//        FetchDetails fetchDetails = new FetchDetails();
//        String ssn = fetchDetails.fetchSSN();
        String ssn = this.fetchSSN();

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        FetchDetails fetchDetails = new FetchDetails();
        this.first_name = fetchDetails.dbStringAccessor(query, condition,label);

        return this.first_name;
    }

    public String fetchPhoneNo() {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

//        FetchDetails fetchDetails = new FetchDetails();
//        String ssn = fetchDetails.fetchSSN();
        String ssn = this.fetchSSN();

        FetchDetails fetchDetails = new FetchDetails();
        this.phone_no = fetchDetails.dbStringAccessor(query, condition, label);

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
