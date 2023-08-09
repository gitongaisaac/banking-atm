package org.atm_banking;

import java.util.Random;

public class Response {

    public static int randomDigit() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static char randomLetter() {
        int randomInt = (int) (Math.random() * 26); // Generates a random integer between 0 and 25
        return (char) ('A' + randomInt);
    }

    public String REFGenerator() {
        String REF = null;
        char letter = randomLetter();
        int digit = randomDigit();

        Random random = new Random();
        int ran = random.nextInt(2);



        return REF;
    }

    public static void main(String[] args) {
        int digit = randomDigit();
        System.out.println(digit);

//        char letter = randomLetter();
//        System.out.println(letter);
    }
}
