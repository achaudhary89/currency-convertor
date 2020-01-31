package com.anz.currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class CurrencyTest {
    @Test
    void testCurrency() {
        Currency currency = new Currency("test",false);
        currency.setPrecision(2);
        ObjectOutputStream out = null;
        Currency currency1 = null;

        try {
            FileOutputStream file = new FileOutputStream("test.txt");
            out = new ObjectOutputStream(file);
            out.writeObject(currency);
            out.close();
            file.close();

            FileInputStream file1 = new FileInputStream("test.txt");
            ObjectInputStream in = new ObjectInputStream(file1);

            currency1 = (Currency) in.readObject();

            in.close();
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(currency.getName(),currency1.getName());
        Assertions.assertEquals(currency.getIsVisited(), currency1.getIsVisited());
        Assertions.assertEquals(currency.getPrecision(), currency1.getPrecision());
    }

}