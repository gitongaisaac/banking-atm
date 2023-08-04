package org.atm_banking;

import org.db_banking.FetchDetails;

/* Check balance account. Has one method: balance() */
public class Balance extends FetchDetails {

    /* Displays the balance of the user */
    public static void balance(){
        Balance balance = new Balance();
        double total_balance = balance.fetchTotalBalance();

        System.out.println("Your account balance is $" + total_balance);
    }

}
