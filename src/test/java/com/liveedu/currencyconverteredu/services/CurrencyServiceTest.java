package com.liveedu.currencyconverteredu.services;

import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {

    @Mock
    private CurrencyRepository repository;

    private CurrencyService subject;

    @Before()
    public void setup() {
        subject = new CurrencyService(repository);
    }

    @Test
    public void getAllCurrenciesTestEmpty() {

        //При создании как бы репозитория положим туда пустой лист.
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList());

        List<Currency> currencies = subject.getAllCurrencies();
        System.out.println(currencies);
        //Проверяем, что лист пустой.
        Assert.assertTrue(currencies.isEmpty());
    }

    @Test
    public void getAllCurrenciesTestAreSorted() {

        Currency currencyZMW = new Currency("ZMW", 1);
        Currency currencyEUR = new Currency("EUR", 1);
        Currency currencyAED = new Currency("AED", 4.2);
        Currency currencyUSD = new Currency("USD", 0.8);

        //Пишем в заглушку-мокито лист объетов Currency
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(currencyZMW, currencyEUR, currencyUSD, currencyAED));

        //Получаем из репозитория (из заглушки) список Currency
        List<Currency> currencies = subject.getAllCurrencies();
        System.out.println(currencies);
        Assert.assertTrue(!currencies.isEmpty());
        // Test if they are sorted
        Assert.assertEquals(currencies.get(0), currencyAED);
        Assert.assertEquals(currencies.get(1), currencyEUR);
        Assert.assertEquals(currencies.get(2), currencyUSD);
        Assert.assertEquals(currencies.get(3), currencyZMW);
    }

    @Test(expected = NullPointerException.class)
    public void getAllCurrenciesTestGivesNullPointerException() {

        //Пишим в заглушку-мокито null
        Mockito.when(repository.findAll()).thenReturn(null);
        //Проверяем, что при обращении к репозиторию получим null
        subject.getAllCurrencies();
    }

}