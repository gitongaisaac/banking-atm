package org.atm_banking;

import java.util.Random;

public class Response {
    int refCount = 0;

//    String ref;
    StringBuilder ref = new StringBuilder();

    public static String randomDigit() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }

    public static char randomLetter() {
        int randomInt = (int) (Math.random() * 26); // Generates a random integer between 0 and 25
        return (char) ('A' + randomInt);
    }

    public String REFGenerator() {
        refCount++;

        String digit = randomDigit();
        char letter = randomLetter();

        Random random = new Random();
        int ran = random.nextInt(2);

            if (ran == 0) {
                if (refCount <= 10) {
                    ref.append(digit);
                    REFGenerator();
                }

            } else {
                if (refCount <= 10) {
                    ref.append(letter);
                    REFGenerator();
                }
            }

        return ref.toString();
    }

    public static void main(String[] args) {
        Response response = new Response();
        String ref = response.REFGenerator();
        System.out.println(ref);
    }
}
