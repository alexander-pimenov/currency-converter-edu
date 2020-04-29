package com.liveedu.currencyconverteredu.repositories;

import com.liveedu.currencyconverteredu.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
