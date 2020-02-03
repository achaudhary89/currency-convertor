package com.anz.reader;

import com.anz.currency.Currency;

import java.io.Serializable;

public class InputReader implements Serializable {

    private Currency base;

    private Currency terms;

    private double amount;

    public InputReader(String input) {
        String[] inputArray = input.split(" ");
        this.base = new Currency(inputArray[0], false);
        this.terms = new Currency(inputArray[3], false);
        this.amount = Double.valueOf(inputArray[1]);

    }

    public Currency getBase() {
        return base;
    }

    public void setBase(Currency base) {
        this.base = base;
    }

    public Currency getTerms() {
        return terms;
    }

    public void setTerms(Currency terms) {
        this.terms = terms;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
