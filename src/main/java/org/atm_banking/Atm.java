package org.atm_banking;

/* Import packages */
import org.db_banking.Requests;

import java.util.Scanner;

/* This is the main class and contains the main method. Has 4 methods: activity(), signIn(), switchActivity(), and
 * getAccountNo(). It extends the fetchDetails() class to use its methods to fetch basic user details such as
 * account_pin */
public class Atm extends Requests {
    private int account_no;

    double amt;

    /* An accessor to access the account_no */
    public int getAccountNo() {
        return this.account_no;
    }

    /* Displays the activities that the user can perform on their account after they sign in and are validated.
     * The user performs a specific activity by entering the number corresponding to the activity they wish to access */
    public void activity() {
        System.out.println("\n--------------------------------------\n");

        String activity = """
                Which account do you want to access
                1. Check balance
                2. Deposit\s
                3. Withdraw \s
                4. Transfer \s
                5. Transaction history
                6. Quit
                """;

        System.out.println(activity);
    }

    /* Takes care of the validation. It allows the user to enter their account number and the pin and the
     * system validates these credentials. If the credentials are correct. The user can access the account. */
    public void signIn() {
        Scanner scanner = new Scanner(System.in);

        // Account number (input from user)
        System.out.print("Account Number: ");
        this.account_no = scanner.nextInt();

        // Requests to fetch the account pin
        Requests requests = new Requests();
        int enteredPinNo = requests.fetchAccountPin(this.account_no);

        // PIn (User input)
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

    /* Directs the user to which activity they want to perform by switching the different classes containing the various
     * banking activities i.e. checkBalance() for checking balance, deposit() For depositing cash, withdraw() for withdrawing  cash
     * transfer() for transferring funds and transHIs() (Transaction history). */
    public void switchActivity() {
        System.out.print("\nChoice: ");

        /* Accepts input from the user */
        Scanner scanner = new Scanner(System.in);
        int switchActivity = scanner.nextInt();

        /* A switch class for switching between the different class methods according to the input entered by the user
        *  1. Balance          2. Deposit          3.Withdraw
        *  4. Transfer              5. Transaction History          6. Quit */
        switch (switchActivity) {
            case 1 -> {
                Balance.balance(this.account_no);
                this.activity();
                this.switchActivity();
            }
            case 2 -> {
                Deposit deposit = new Deposit();
                this.amt = deposit.getTransAmt();
                deposit.deposit(this.account_no);
                this.activity();
                this.switchActivity();
            }
            case 3 -> {
                Withdraw withdraw = new Withdraw();
                this.amt = withdraw.getTransAmt();
                withdraw.withdraw(this.account_no);
                this.activity();
                this.switchActivity();
            }
            case 4 -> {
                Transfer.transfer();
                this.activity();
                this.switchActivity();
            }
            case 5 -> {
                TransHis.transHis();
                this.activity();
                this.switchActivity();
            }
            case 6 -> System.out.println("\nThank you for using our services\n");
            default -> System.out.println("Activity " + switchActivity + " does not exist");
        }
    }

    /* *********************************************************************************************************** */
    public static void main(String[] args) {
        Atm atm = new Atm();
        atm.signIn();
        atm.switchActivity();
    }
}