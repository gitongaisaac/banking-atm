package org.atm_banking;

import java.util.Random;

/* REFGenerator. Generates the Reference number for a transaction. It has 3 classes. It generates 10 random digits
 * made up of letters and numbers. */
public class REFGenerator {
    /* String Builder */
    StringBuilder ref = new StringBuilder();

    /* Hold the number of recursive calls. */
    int refCount = 0;


    /* Generates a random digit and converts to string for appending to ref */
    public static String randomDigit() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10));
    }

    /* Generates a random letter (Capital letter) for appending to ref */
    public static char randomLetter() {
        int randomInt = (int) (Math.random() * 26); // Generates a random integer between 0 and 25
        return (char) ('A' + randomInt);
    }

    /* Converts the generated random letters and numbers to a REF. Uses stringBuilder to convert the letters and
     * digits to a string */
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
