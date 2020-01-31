package com.anz.currency;

import java.io.Serializable;

public class CurrencyPair implements Serializable {

    private Currency base;
    private Currency terms;
    private double rate;

    public CurrencyPair(Currency base, Currency terms, double rate) {
        this.base = base;
        this.terms = terms;
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
