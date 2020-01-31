package com.anz.currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyPairTest {

    @Test
    void testCurrencyPair() {
        Currency base = new Currency("test",false);
        base.setPrecision(2);

        Currency terms = new Currency("test1",false);
        base.setPrecision(2);

        CurrencyPair currencyPair = new CurrencyPair(base, terms, 0.83);
        ObjectOutputStream out = null;
        CurrencyPair currencyPair1  =   null;

        try {
            FileOutputStream file = new FileOutputStream("test.txt");
            out = new ObjectOutputStream(file);
            out.writeObject(currencyPair);
            out.close();
            file.close();

            FileInputStream file1 = new FileInputStream("test.txt");
            ObjectInputStream in = new ObjectInputStream(file1);

            currencyPair1 = (CurrencyPair) in.readObject();

            in.close();
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(currencyPair.getBase(),currencyPair1.getBase());
        Assertions.assertEquals(currencyPair.getTerms(), currencyPair1.getTerms());
        Assertions.assertEquals(currencyPair.getRate(), currencyPair1.getRate());
    }
}