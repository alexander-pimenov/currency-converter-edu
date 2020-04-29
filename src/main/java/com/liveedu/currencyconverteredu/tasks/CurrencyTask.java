package com.liveedu.currencyconverteredu.tasks;

import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.models.CurrencyDTO;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
public class CurrencyTask {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Value("${fixer.io.apiKey}")
    private String fixerIoApiKey;

    @PostConstruct
    private void getRatesTask(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject(fixerIoApiKey, CurrencyDTO.class);
            forObject.getRates().forEach((key, value) ->{
                Currency currency = new Currency(key, value);
                this.currencyRepository.save(currency);
            });

        }catch (RestClientException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
