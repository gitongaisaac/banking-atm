package org.atm_banking;

import java.util.Scanner;

public class Withdraw {
    public static int withdraw (){
        int amountInTheAccount = 50000;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount you wish to withdraw: ");
        int withdrawCash = scanner.nextInt();
        int totalAmount = amountInTheAccount - withdrawCash;
        System.out.println("Your account balance is: " + totalAmount);

        return totalAmount;
    }

    public static void main(String[] args) {
        withdraw();
    }
}
