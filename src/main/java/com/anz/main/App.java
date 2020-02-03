package com.anz.main;

import com.anz.constants.CommonConstants;
import com.anz.currency.CurrencyGraph;
import com.anz.currency.CurrencyPair;
import com.anz.currency.ForexService;
import com.anz.currency.ForexServiceImpl;
import com.anz.dataloader.CurrencyPairsLoader;
import com.anz.dataloader.PropertiesLoader;
import com.anz.reader.InputReader;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Properties precisionProperties = null;
        System.out.println("Enter the input String ::");
        Scanner scanner = new Scanner(System.in);
        String input    =   scanner.nextLine();
        InputReader reader = new InputReader(input);
        try {
            init();
            precisionProperties  =   PropertiesLoader.loadProperties(CommonConstants.PRECISION_PROPERTIES_FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error Occurred "+e.getMessage());
            e.printStackTrace();
        }

        ForexService service =  new ForexServiceImpl();
        double rate =   service.getExchangeRate(reader.getBase(), reader.getTerms());
        String result   =   String.format("%."+precisionProperties.getProperty(reader.getTerms().getName())+"f", +reader.getAmount()*rate);
        if(rate == -1){
            System.out.println("Unable to find rate for "+reader.getBase().getName()+"/"+reader.getTerms().getName());
        }else{
            System.out.println(" "+reader.getBase().getName()+" "+reader.getAmount()+" = "+reader.getTerms().getName()+" "+result);
        }


    }

    public static void init() throws IOException {
        List<CurrencyPair>  currencyPairList    =    CurrencyPairsLoader.loadCurrencyPairs(PropertiesLoader.loadProperties(CommonConstants.EXCHANGE_RATE_PROPERTIES_FILE_NAME));
        CurrencyGraph graph =   CurrencyGraph.getInstance();
        for(CurrencyPair currencyPair : currencyPairList){
            graph.addCurrencyPair(currencyPair, graph);
        }
    }
}
