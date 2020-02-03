package com.anz.currency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CurrencyGraphTest {

    @Test
    void testSingleton(){
        CurrencyGraph currencyGraph = CurrencyGraph.getInstance();
        CurrencyGraph currencyGraph1    =   CurrencyGraph.getInstance();
        Assertions.assertEquals(currencyGraph, currencyGraph1);
    }


    @Test
    void addCurrencyPair() {
        CurrencyGraph graph = CurrencyGraph.getInstance();
        Currency base = new Currency("test",false);
        base.setPrecision(2);

        Currency terms = new Currency("test1",false);
        base.setPrecision(2);

        CurrencyPair currencyPair = new CurrencyPair(base, terms, 0.83);
        graph.addCurrencyPair(currencyPair, graph);

        Assertions.assertEquals(graph.getGraph().entrySet().size(), 2);
    }

}