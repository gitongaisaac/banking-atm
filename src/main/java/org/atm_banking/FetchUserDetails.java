package org.atm_banking;

public class FetchUserDetails extends SignIn {
    int account_no;

    double total_balance = 0;

    String ssn = null;

    String account_type = null;

    public FetchUserDetails() {
        FetchUserDetails fetchDetails = new FetchUserDetails();
        account_no = fetchDetails.account_no;
        System.out.println("Constructor");
        System.out.println(account_no);
    }

    protected double getTotalBalance(int account_no) {
        FetchUserDetails fetchDetails = new FetchUserDetails();
        account_no = fetchDetails.account_no;
        return 0;
    }

    protected  String getSSN(int account_no) {

        return null;
    }

    protected String account_type(int account_no) {

        return null;
    }

    public static void main(String[] args) {
        FetchUserDetails fetchUserDetails = new FetchUserDetails();
    }

}
