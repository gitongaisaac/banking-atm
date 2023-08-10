package org.atm_banking;

import java.util.Random;

public class Response {

    public static String randomDigit() {
        Random random = new Random();
        int digit = random.nextInt(10);
//        String dig = digit.toString();
//        return digit.toString();
        return null;
    }

    public static char randomLetter() {
        int randomInt = (int) (Math.random() * 26); // Generates a random integer between 0 and 25
        return (char) ('A' + randomInt);
    }

    public String REFGenerator() {
        String REF = null;
        char letter = randomLetter();
//        char digit = randomDigit();

        Random random = new Random();
        int ran = random.nextInt(2);



        return REF;
    }

    public static void main(String[] args) {
//        char digit = randomDigit();
//        System.out.println(digit + "8");

        System.out.println("8" + "0");

//        char letter = randomLetter();
//        System.out.println(letter);
    }
}
