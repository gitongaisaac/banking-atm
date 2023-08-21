package org.atm_banking;

import org.db_banking.Requests;

import java.util.Scanner;

public class Transfer extends Requests {
    final String trans_name = "Transfer";

    String trans_party, ssn;

    double trans_amt, trans_bal;

    int account_no;

    public Transfer(int account_no) {
        this.account_no = account_no;

        this.ssn = fetchSSN(account_no);
    }

    public void enterParty() {
        Scanner scanner = new Scanner(System.in);

//        this.trans_party = scanner.nextInt();
    }

    public void transfer() {

    }
}
