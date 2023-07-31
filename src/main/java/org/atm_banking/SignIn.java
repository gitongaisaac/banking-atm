package org.atm_banking;

/* Import packages */
import java.util.Scanner;
import org.db_banking.DbNonParamAccessors;

/* This class takes care of user validation to ensure that users only access accounts to which they have access to.
 * Has 2 methods. activity() and signIn()  */
class SignIn extends DbNonParamAccessors {

    /* This method Displays the activities that the user can perform on their account after they sign in and are validated.
     * The user performs a specific activity by entering the number corresponding to the activity they wish to access */
    public static void activity() {

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
    public static void signIn() {
        int accountNo = 9804;
        int pinNo = 9804;
        Scanner scanner = new Scanner (System.in);

        // Account number
        System.out.print("Account Number: ");
        int enteredNo = scanner.nextInt();

        String query = "SELECT account_pin FROM Account_info WHERE account_no = enteredNo";

        SignIn signIn = new SignIn();
        signIn.dbIntegerAccessor(query);

        // PIn
        System.out.print("Pin number: ");
        int enteredPin = scanner.nextInt();

        /* Validation. Checks if the Account Number entered corresponds to the pin. It gives the user 3 chances to enter
         * the credentials */
        if (enteredNo != accountNo & enteredPin != pinNo) {
            for (int i = 1; i < 3; i++ ) {
                System.out.println("The details do not match");

                System.out.print("Account Number: ");
                enteredNo = scanner.nextInt();

                System.out.print("Pin number: ");
                enteredPin = scanner.nextInt();
            }
        }

        else
            activity();

    }

    /* *********************************************************************************************************** */
    public static void main(String[] args) {
        String SSN = "096-43-2509";
        String query = "SELECT last_name FROM Person_info WHERE SSN = SSN";

        SignIn signIn = new SignIn();
        String result = signIn.dbStringAccessor(query);

        System.out.println(result);
    }
}
