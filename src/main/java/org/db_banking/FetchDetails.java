package org.db_banking;

import org.atm_banking.SignIn;

public class FetchDetails extends DbParamAccessors {
    int account_no;

    double total_balance;

    String ssn, account_type, last_name, first_name, phone_no;

    public FetchDetails() {
//        SignIn signIn = new SignIn();
//        this.account_no = signIn.account_no;
//        this.account_no = account_no;
        System.out.println("Account Number is: " + this.account_no + " from fetch details");
    }

    public int getAccountNo() {
        return this.account_no;
    }

    public void setAccountNo(int account_no) {
        this.account_no = account_no;
    }

    public double fetchTotalBalance() {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "total_balance";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.total_balance = dbParamAccessors.dbDoubleAccessor(query, condition, label);

        return this.total_balance;
    }

    public   String fetchSSN() {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "SSN";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.ssn = dbParamAccessors.dbStringIAccessor(query, condition, label);

        return this.ssn;
    }

    public String fetchAccountType() {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "account_type";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.account_type = dbParamAccessors.dbStringIAccessor(query, condition, label);


        return this.account_type;
    }

    public String fetchLastName() {
        String query, condition, label;

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.fetchSSN();

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.last_name = dbParamAccessors.dbStringAccessor(query, condition, label);

        return this.last_name;
    }

    public String fetchFirstName() {
        String query, condition, label;

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.fetchSSN();

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.first_name = dbParamAccessors.dbStringAccessor(query, condition, label);

        return this.first_name;
    }

    public String fetchPhoneNo() {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.fetchSSN();

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.phone_no = dbParamAccessors.dbStringAccessor(query, condition, label);

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
