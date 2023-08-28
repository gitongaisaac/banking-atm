package org.atm_banking;

import java.util.Random;

public class REFGenerator {
    /* String Builder */
    StringBuilder ref = new StringBuilder();

    /* Hold the number of recursive calls. */
    int refCount = 0;

    public static String randomDigit() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }

    public static char randomLetter() {
        int randomInt = (int) (Math.random() * 26); // Generates a random integer between 0 and 25
        return (char) ('A' + randomInt);
    }

    public String refGenerator() {
        refCount++;

        String digit = randomDigit();
        char letter = randomLetter();

        Random random = new Random();
        int ran = random.nextInt(2);

            if (ran == 0) {
                if (refCount <= 10) {
                    ref.append(digit);
                    refGenerator();
                }

            } else {
                if (refCount <= 10) {
                    ref.append(letter);
                    refGenerator();
                }
            }

        return ref.toString();
    }
}
