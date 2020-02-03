package com.anz.currency;

public interface ForexService {
    public double getExchangeRate(Currency base, Currency terms);
}
