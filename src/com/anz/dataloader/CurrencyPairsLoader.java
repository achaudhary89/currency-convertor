package com.anz.dataloader;

import com.anz.currency.Currency;
import com.anz.currency.CurrencyPair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class CurrencyPairsLoader {
    public static List<CurrencyPair> loadCurrencyPairs(Properties properties) throws IOException {
        List<CurrencyPair> currencyPairList = new ArrayList<>();
        Set<String> currencyPairsSet   =   properties.stringPropertyNames();
        for(String pairs : currencyPairsSet){
            Currency base = new Currency(pairs.substring(0,3), false);
            Currency terms = new Currency(pairs.substring(3),false);
            CurrencyPair currencyPair =   new CurrencyPair(base,terms,Double.valueOf(properties.getProperty(pairs)));
            currencyPairList.add(currencyPair);
        }

        return currencyPairList;
    }
}
