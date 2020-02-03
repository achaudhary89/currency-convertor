package com.anz.currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyGraph {

    private   Map<Currency, Map<Currency, Double>> graph  =   null;
    private static CurrencyGraph INSTANCE = null;

    private CurrencyGraph(){
        this.graph = new HashMap<Currency, Map<Currency, Double>>();
    }

    public static CurrencyGraph getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CurrencyGraph();
        }else
            return INSTANCE;

        return INSTANCE;
    }

    public void addCurrencyPair(CurrencyPair pair, CurrencyGraph currencyGraph){
        Currency base = pair.getBase();
        Currency terms = pair.getTerms();
        Map<Currency,Map<Currency,Double>> graph =   currencyGraph.getGraph();
        graph.putIfAbsent(base, new HashMap<Currency, Double>());
        graph.get(base).put(terms, pair.getRate());
        graph.putIfAbsent(terms,new HashMap<Currency,Double>());
        graph.get(terms).put(base,1/pair.getRate());
    }

    public  Map<Currency, Map<Currency, Double>> getGraph() {
        return graph;
    }

}
