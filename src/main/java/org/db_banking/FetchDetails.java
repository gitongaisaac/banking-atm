package org.db_banking;

import org.atm_banking.SignIn;

public class FetchDetails extends DbParamAccessors {
    int account_no;

    double total_balance = 0;

    String ssn, account_type, last_name, first_name, phone_no = null;

    public FetchDetails() {
        SignIn signIn = new SignIn();
        this.account_no = signIn.account_no;
    }

    protected double getTotalBalance() {
        String query = "SELECT total_balance FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "total_balance";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.total_balance = dbParamAccessors.dbDoubleAccessor(query, condition, label);

        return this.total_balance;
    }

    protected  String getSSN() {
        String query = "SELECT SSN FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "SSN";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.ssn = dbParamAccessors.dbStringIAccessor(query, condition, label);

        return this.ssn;
    }

    protected String getAccountType() {
        String query = "SELECT account_type FROM Account_info WHERE account_no = ?";
        int condition = this.account_no;
        String label = "account_type";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.account_type = dbParamAccessors.dbStringIAccessor(query, condition, label);


        return this.account_type;
    }

    protected String getLastName() {
        String query, condition, label;

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.getSSN();

        query = "SELECT last_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "last_name";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.last_name = dbParamAccessors.dbStringAccessor(query, condition, label);

        return this.last_name;
    }

    protected String getFirstName() {
        String query, condition, label;

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.getSSN();

        query = "SELECT first_name FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "first_name";

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.first_name = dbParamAccessors.dbStringAccessor(query, condition, label);

        return this.first_name;
    }

    protected String getPhoneNo() {
        String query, condition, label;

        query = "SELECT phone_no FROM Person_info WHERE SSN = ?";
        condition = ssn;
        label = "phone_no";

        FetchDetails fetchDetails = new FetchDetails();
        String ssn = fetchDetails.getSSN();

        DbParamAccessors dbParamAccessors = new DbParamAccessors();
        this.phone_no = dbParamAccessors.dbStringAccessor(query, condition, label);

        return this.phone_no;
    }
}
