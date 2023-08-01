package org.atm_banking;

import org.db_banking.DbParamAccessors;

abstract class FetchUserDetails extends DbParamAccessors {
    int account_no;

    double total_balance = 0;

    String ssn = null;

    String account_type = null;

    public FetchUserDetails() {
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
        this.ssn = dbParamAccessors.dbStringAccessor(query, condition, label);

        return null;
    }

    protected String account_type() {



        return null;
    }

    public static void main(String[] args) {

    }

}
