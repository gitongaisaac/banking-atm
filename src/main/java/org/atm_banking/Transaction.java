package org.atm_banking;

import org.db_banking.Requests;

public class Transaction extends Requests {
    String ref;

    public String getRef() {
        REFGenerator refGenerator = new REFGenerator();
        return refGenerator.refGenerator();
    }
    public void createEntry() {

    }

    public static void main(String[] args) {

    }
}
