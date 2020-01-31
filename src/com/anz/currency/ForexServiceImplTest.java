package com.anz.currency;

import com.anz.main.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ForexServiceImplTest {

    @Test
    void getExchangeRate() {
        Currency currency = new Currency("USD",false);
        Currency currency1 = new Currency("AUD",false);
        ForexService service = new ForexServiceImpl();
        double res = service.getExchangeRate(currency1, currency);
        Assertions.assertEquals(res , .8371);

    }

    @Test
    void getExchangeRate_crossCurrency() {
        Currency currency = new Currency("DKK",false);
        Currency currency1 = new Currency("AUD",false);
        ForexService service = new ForexServiceImpl();
        double res = service.getExchangeRate(currency1, currency);
        Assertions.assertEquals(res , 5.057606617945594);

    }

    @Test
    void getExchangeRate_notFound(){
        Currency currency = new Currency("KRW",false);
        Currency currency1 = new Currency("FJD",false);
        ForexService service = new ForexServiceImpl();
        double res = service.getExchangeRate(currency1, currency);
        Assertions.assertEquals(res , -1);
    }

    @Test
    void getExchangeRate_multilevel(){
        /*
        GBP - USD - EUR - NOK
         */
        Currency currency1 = new Currency("GBP",false);
        Currency currency = new Currency("NOK",false);
        ForexService service = new ForexServiceImpl();
        double res = service.getExchangeRate(currency1, currency);
        Assertions.assertEquals(res , 11.034897547706048);
    }



    @BeforeEach
    void setUp() throws IOException {
        App.init();
    }
}