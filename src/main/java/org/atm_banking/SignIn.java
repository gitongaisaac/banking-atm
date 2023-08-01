package org.atm_banking;

/* Import packages */
import java.util.Scanner;
import org.db_banking.DbNonParamAccessors;
import org.db_banking.DbParamAccessors;

/* This class takes care of user validation to ensure that users only access accounts to which they have access to.
 * Has 2 methods. activity() and signIn()  */
class SignIn extends DbParamAccessors {

    int account_no;

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
        account_no = scanner.nextInt();

        /* Fetch the account_pin which corresponds to the account_no entered. Uses the DbParamAccessors class to fetch. */
        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
        int condition = account_no;
        String label = "account_pin";

        SignIn signIn = new SignIn();
        int result = signIn.dbIntAccessor(query, condition, label);

        // PIn
        System.out.print("Pin number: ");
        int enteredPin = scanner.nextInt();

        /* Validation. Checks if the Account Number entered corresponds to the pin. It gives the user 3 chances to enter
         * the credentials */
        if (enteredPin != result) {
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
//        String query = "SELECT account_pin FROM Account_info WHERE account_no = ?";
//        int condition = 123456789;
//        String label = "account_pin";
//
//        SignIn signIn = new SignIn();
//        int result = signIn.dbIntAccessor(query, condition, label);
//
//        System.out.println(result);
//        signIn();
    }
}
