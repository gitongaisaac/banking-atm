package org.atm_banking;

/* Built in packages */
import java.util.Scanner;

/* User Packages */
import org.db_banking.FetchDetails;

/* This class takes care of user validation to ensure that users only access accounts to which they have access to.
 * Has 2 methods. activity() and signIn()  */
public class SignIn {

    private int account_no;

    public int getAccountNo() {
        return this.account_no;
    }


    /* This method Displays the activities that the user can perform on their account after they sign in and are validated.
     * The user performs a specific activity by entering the number corresponding to the activity they wish to access */
    public static void activity() {
        System.out.println("\n--------------------------------------\n");

        String activity = "Which account do you want to access"
                + "\n1. Check balance"
                + "\n2. Deposit "
                + "\n3. Withdraw  "
                + "\n4. Transfer  "
                + "\n5. Transaction history"
                + "\n6. Quit";

        System.out.println(activity);
    }

    /* *********************************************************************************************************** */
    /* This method takes care of the actual validation. It allows the user to enter their account number and the pin and
     * the system validates these credentials. If the credentials are correct. The user can access the account */
    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        // Account number
        System.out.print("Account Number: ");
        this.account_no = scanner.nextInt();

        FetchDetails fetchDetails = new FetchDetails();
        int enteredPinNo = fetchDetails.fetchAccountPin(this.account_no);

        // PIn
        System.out.print("Pin number: ");
        int enteredPin = scanner.nextInt();

        /* Validation. Checks if the Account Number entered corresponds to the pin. It gives the user 3 chances to enter
         * the credentials */
        if (enteredPin != enteredPinNo) {
                System.out.println("The details do not match");
                System.out.println();
                System.out.println("-------------------------------------------------");
                System.out.println();

                    signIn();

        } else {
            activity();
        }
    }

    /* *********************************************************************************************************** */
    public static void main(String[] args) {
        SignIn signIn = new SignIn();
        signIn.signIn();
    }
}
