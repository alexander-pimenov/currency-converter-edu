package com.liveedu.currencyconverteredu.utils;

import lombok.experimental.UtilityClass;

import java.time.Instant;

@UtilityClass
public class DateUtils {
    /**
     * Compare two dates with 2021-11-11T11:11:11.000Z and 2021-11-11T11:11:11Z formats
     */
    public static boolean isStringDatesEqual(String firstDate, String secondDate) {
        return firstDate == null ?
                secondDate == null :
                secondDate != null && Instant.parse(firstDate).equals(Instant.parse(secondDate));
    }
}
