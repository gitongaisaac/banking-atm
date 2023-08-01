package org.atm_banking;

/* Check balance account. Has one method: balance() */
public class Balance {

    /* Displays the balance of the user */
    public static void balance(){

        System.out.println("Your account balance is 50,000");
        SignIn.activity();
        Atm.switchActivity();
    }

}
