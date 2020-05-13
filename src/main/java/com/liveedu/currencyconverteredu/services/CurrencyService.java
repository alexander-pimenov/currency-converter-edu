package com.liveedu.currencyconverteredu.services;

import com.liveedu.currencyconverteredu.models.ConversionCurrency;
import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = this.currencyRepository.findAll();
        currencyList.sort(Comparator.comparing(Currency::getName));
        return currencyList;
    }

    public Currency getCurrencyBiId(String id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return new Currency("This name of Currency is not correct.", 0.0);
    }

    public Optional<Double> convert(ConversionCurrency conversionCurrency) {

        //Достаем валюты из БД
        Optional<Currency> toOptional = this.currencyRepository.findById(conversionCurrency.getTo().toUpperCase());
        Optional<Currency> fromOptional = this.currencyRepository.findById(conversionCurrency.getFrom().toUpperCase());

        //Проверяем, что такие валюты есть.
        if (toOptional.isPresent() && fromOptional.isPresent()) {

            //И сумму валюты ввели не отрицательную
            if (conversionCurrency.getValue() < 0) {
                return Optional.empty();
            }

            Currency to = toOptional.get();
            Currency from = fromOptional.get();
            Double toValue = to.getValueInEuros();
            Double fromValue = from.getValueInEuros();

            //Вычисляем значение валют
            Double result = toValue * conversionCurrency.getValue() / fromValue;

            return Optional.of(result);
        }

        return Optional.empty();
    }

}
