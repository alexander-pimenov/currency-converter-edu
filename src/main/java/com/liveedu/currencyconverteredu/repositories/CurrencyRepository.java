package com.liveedu.currencyconverteredu.repositories;

import com.liveedu.currencyconverteredu.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
    Optional<Currency> findById(String id);
}
