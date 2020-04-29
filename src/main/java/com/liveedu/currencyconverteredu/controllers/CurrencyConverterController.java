package com.liveedu.currencyconverteredu.controllers;

import com.liveedu.currencyconverteredu.models.ConversionCurrency;
import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.services.CurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyConverterController {

    CurrencyService currencyService;

    public CurrencyConverterController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    //List all currencies
    @GetMapping(value = "/currencies", produces = {"application/json"})
    public ResponseEntity<List<Currency>> getAllCurrencies() {
        return new ResponseEntity<>(this.currencyService.getAllCurrencies(), HttpStatus.OK);
    }

    //Converts between two currencies
    @RequestMapping(value = "/currency-converter", produces = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<Double> convertCurrencies(@RequestBody ConversionCurrency conversionCurrency) {
        Optional<Double> resultOptional = this.currencyService.convert(conversionCurrency);
        if (resultOptional.isPresent()) {
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
