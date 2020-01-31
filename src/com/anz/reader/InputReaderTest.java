package com.anz.reader;

import com.anz.currency.Currency;
import com.anz.currency.CurrencyPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    void testInputReader() {
        InputReader reader = new InputReader("AUD 100.00 in USD");
        ObjectOutputStream out = null;
        InputReader reader1  =   null;

        try {
            FileOutputStream file = new FileOutputStream("test.txt");
            out = new ObjectOutputStream(file);
            out.writeObject(reader);
            out.close();
            file.close();

            FileInputStream file1 = new FileInputStream("test.txt");
            ObjectInputStream in = new ObjectInputStream(file1);

            reader1 = (InputReader) in.readObject();

            in.close();
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(reader.getBase(),reader1.getBase());
        Assertions.assertEquals(reader.getTerms(), reader1.getTerms());
        Assertions.assertEquals(reader.getAmount(), reader1.getAmount());

    }

}