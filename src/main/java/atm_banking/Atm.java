package atm_banking;

/* Import packages */
import java.util.Scanner;

/* This is the main class and contains the main method. Has only one method: switchActivity and the main method */
public class Atm {

    /* Directs the user to which activity they want to perform by switching the different classes containing the various
     * banking activity i.e. CheckBalance for checking balance, Deposit For depositing cash, withdraw for withdrawing  cash
     * Transfer for transferring funds and Transaction history. */
    public static void switchActivity() {

        System.out.print("Account: ");

        /* Accepts input from the user */
        Scanner scanner = new Scanner(System.in);
        int switchActivity = scanner.nextInt();

        /* A switch claus for switching between the different class methods according to the input entered by the user
        *  1. CheckBalance          2. Deposit          3.Withdraw
        *  4. Transfer              5. Transaction History          6. Quit */
        switch (switchActivity) {
            case 1:
                CheckBalance.balance();
                break;
            case 2:
                Deposit.deposit(50000);
                break;
            case 3:
                Withdraw.withdraw(50000);
                break;
            case 4:
                Transfer.transfer();
                break;
            case 5:
                TransHis.transHis();
                break;
            case 6:
                System.out.println("Thank you for using our services");
            default:
                System.out.println("Activity " + switchActivity + " does not exist");
        }

    }

//    public static void loop() {
//        int i = 0;
//        do {
//            Atm.switchClass();
//        }
//        while (i < 1);
//    }

    public static void main(String[] args) {
        SignIn.signIn();
        switchActivity();

    }
}