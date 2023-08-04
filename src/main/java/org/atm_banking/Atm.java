package org.atm_banking;

/* Import packages */
import org.db_banking.FetchDetails;

import java.util.Scanner;

/* This is the main class and contains the main method. Has only one method: switchActivity() and the main method */
public class Atm extends FetchDetails {

    /* Directs the user to which activity they want to perform by switching the different classes containing the various
     * banking activity i.e. checkBalance() for checking balance, deposit() For depositing cash, withdraw() for withdrawing  cash
     * transfer() for transferring funds and transHIs() (Transaction history). */
    public static void switchActivity() {

        System.out.print("\nChoice: ");

        /* Accepts input from the user */
        Scanner scanner = new Scanner(System.in);
        int switchActivity = scanner.nextInt();

        /* A switch claus for switching between the different class methods according to the input entered by the user
        *  1. Balance          2. Deposit          3.Withdraw
        *  4. Transfer              5. Transaction History          6. Quit */
        switch (switchActivity) {
            case 1 -> {
                Balance.balance();
                SignIn.activity();
                Atm.switchActivity();
            }
            case 2 -> {
                Deposit.deposit(50000);
                SignIn.activity();
                Atm.switchActivity();
            }
            case 3 -> {
                Withdraw.withdraw(50000);
                SignIn.activity();
                Atm.switchActivity();
            }
            case 4 -> {
                Transfer.transfer();
                SignIn.activity();
                Atm.switchActivity();
            }
            case 5 -> {
                TransHis.transHis();
                SignIn.activity();
                Atm.switchActivity();
            }
            case 6 -> System.out.println("Thank you for using our services");
            default -> System.out.println("Activity " + switchActivity + " does not exist");
        }

    }

    /* *********************************************************************************************************** */
    public static void main(String[] args) {
        SignIn signIn = new SignIn();
        signIn.signIn();
        switchActivity();

    }
}