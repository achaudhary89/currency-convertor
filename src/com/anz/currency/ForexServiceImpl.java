package com.anz.currency;

import java.util.Map;

public class ForexServiceImpl implements ForexService {

    @Override
    public double getExchangeRate(Currency base, Currency terms) {
        Map<Currency, Map<Currency, Double>> graph  =   CurrencyGraph.getInstance().getGraph();
        if(!graph.containsKey(base)){
            return -1;
        }

        if(graph.get(base).containsKey(terms)){
            return graph.get(base).get(terms);
        }
        base.setIsVisited(true);

        for(Map.Entry<Currency, Double> currencyEntry : graph.get(base).entrySet()){

            if(!currencyEntry.getKey().getIsVisited()){
                double rate = getExchangeRate(currencyEntry.getKey(), terms);
                if(rate!= -1){
                    return currencyEntry.getValue()*rate;
                }
            }

        }
        return -1;
    }
}
