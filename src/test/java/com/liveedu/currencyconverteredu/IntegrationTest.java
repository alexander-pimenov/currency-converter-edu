package com.liveedu.currencyconverteredu;

import com.liveedu.currencyconverteredu.models.ConversionCurrency;
import com.liveedu.currencyconverteredu.models.Currency;
import com.liveedu.currencyconverteredu.repositories.CurrencyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

//@RunWith(SpringRunner.class) Аннотация используется для настройки модульного теста, который требовал внедрения зависимостей Spring.
//Это тест стартует контекст, он инициализирует приложение, сервер Томкет, Http-сервер и после инициализации приложения
//он находит порт, который мы хотим использовать (по умолчанию это Определенный порт = 8080),
//он читает application.properties и понимает, что порт по дефолту = 8080
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application.properties")
public class IntegrationTest {

    @Mock
    private CurrencyRepository repository;

    private RestTemplate restTemplate;

    private String basePath = "http://localhost:8080";

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void convertShouldBeSuccessful() {
        Currency currencyEUR = new Currency("EUR", 1);
        Currency currencyUSD = new Currency("USD", 1.15795);

        Mockito.when(repository.findById("EUR")).thenReturn(Optional.of(currencyEUR));
        Mockito.when(repository.findById("USD")).thenReturn(Optional.of(currencyUSD));

        ConversionCurrency conversionCurrency = new ConversionCurrency("EUR", "USD", 10);

        ResponseEntity<Double> responseEntity = restTemplate.postForEntity(basePath + "/currency-converter",
                conversionCurrency, Double.class);
//        ResponseEntity<Double> responseEntity = restTemplate.postForEntity(basePath,
//        conversionCurrency, Double.class);
        System.out.println("ResponseEntity: " + responseEntity);


        //Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

}
