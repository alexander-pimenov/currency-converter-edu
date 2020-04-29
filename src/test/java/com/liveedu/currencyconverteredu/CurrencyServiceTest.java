package com.liveedu.currencyconverteredu;

import com.liveedu.currencyconverteredu.models.ConversionCurrency;
import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import com.liveedu.currencyconverteredu.services.CurrencyService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        Assert.assertFalse(currencies.isEmpty());
        // Test if they are sorted
        //Проверяем объекты Currency в списке
        Assert.assertEquals(currencies.get(0), currencyAED);
        Assert.assertEquals(currencies.get(1), currencyEUR);
        Assert.assertEquals(currencies.get(2), currencyUSD);
        Assert.assertEquals(currencies.get(3), currencyZMW);

        //Проверяем имена валют
        Assert.assertEquals(currencies.get(0).getName(), "AED");
        Assert.assertEquals(currencies.get(1).getName(), "EUR");
        Assert.assertEquals(currencies.get(2).getName(), "USD");
        Assert.assertEquals(currencies.get(3).getName(), "ZMW");
    }

    @Test(expected = NullPointerException.class)
    public void getAllCurrenciesTestGivesNullPointerException() {

        //Пишим в заглушку-мокито null
        Mockito.when(repository.findAll()).thenReturn(null);
        //Проверяем, что при обращении к репозиторию получим null
        subject.getAllCurrencies();
    }

    @Test
    public void convertShouldReturnEmptyWhenNegativeValue() {
        Currency currencyEUR = new Currency("EUR", 1);
        Currency currencyUSD = new Currency("USD", 0.8);

        Mockito.when(repository.findById("EUR")).thenReturn(Optional.of(currencyEUR));
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", 0);
        System.out.println(conversionCurrency);

        Optional<Double> result = this.subject.convert(conversionCurrency);
        System.out.println(result);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void convertShouldReturnEmptyWhenCurrencyDoesNotExist() {
        Currency currencyUSD = new Currency("USD", 0.8);

        Mockito.when(repository.findById("EUR")).thenReturn(Optional.empty());
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", 0);
        System.out.println(conversionCurrency);

        Optional<Double> result = this.subject.convert(conversionCurrency);
        System.out.println(result);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isPresent());
    }

    @Test
    public void convertShouldReturnValue() {
        Currency currencyEUR = new Currency("EUR", 1);
        Currency currencyUSD = new Currency("USD", 1.15795);

        Mockito.when(repository.findById("EUR")).thenReturn(Optional.of(currencyEUR));
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", 10);

        Optional<Double> result = this.subject.convert(conversionCurrency);
        System.out.println(result);

        Assert.assertTrue(result.isPresent());
        double expected = Math.round(8.635951466 * 100.0) / 100.0; //8.64
        double actual = Math.round(result.get()*100.0)/100.0; //8.64
        Assert.assertTrue(expected==actual);
    }

}