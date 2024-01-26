package com.liveedu.currencyconverteredu.tasks;

import static com.liveedu.currencyconverteredu.utils.ThrowableUtils.stackTraceToString;

import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.models.CurrencyDTO;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class CurrencyTask {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Value("${fixer.io.apiKey}")
    private String fixerIoApiKey;

    @PostConstruct
    private void getRatesTask() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO forObject = restTemplate.getForObject(fixerIoApiKey, CurrencyDTO.class);
            if (forObject != null && forObject.isSuccess()) {
                forObject.getRates().forEach((key, value) -> {
                    Currency currency = new Currency(key, value);
                    this.currencyRepository.save(currency);
                });
            }
            log.warn("Либо объект CurrencyDTO = {}, либо доступ к fixerIoApiKey = {} закрыт",
                    forObject != null ? forObject.isSuccess() : null, fixerIoApiKey);
        } catch (RestClientException ex) {
            log.error("Не получилось извлечь данные о валютах из fixerIoApiKey = {}. Ошибка = {}",
                    fixerIoApiKey, stackTraceToString(ex));
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
