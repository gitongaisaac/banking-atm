package org.atm_banking;

import org.db_banking.Requests;

public class Balance extends Requests {
    public static void balance(int account_no) {
        Balance balance = new Balance();
        double total_balance = balance.fetchAccountBalance(account_no);

        System.out.println("Your account balance is $" + total_balance);
    }

}
