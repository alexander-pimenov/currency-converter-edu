package com.liveedu.currencyconverteredu.utils;

import lombok.experimental.UtilityClass;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.TimeZone;

/**
 * <p>Утилитный класс для форматирования в строку и из строки в разные базовые форматы.
 * <p>
 * Created on 20.10.2022
 *
 * @author Kurskiy Alexey
 */
@UtilityClass
public class FormatterUtils {
    public static final SimpleDateFormat IGR_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_KRG = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    public static final SimpleDateFormat DATE_PERIOD_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat FORMAT_DATETIME_FRONTEND = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private static final long K = 1024;
    private static final long M = K * K;
    private static final long G = M * K;
    private static final long T = G * K;

    public static String formatBytes(final long value) {
        final long[] dividers = new long[]{T, G, M, K, 1};
        final String[] units = new String[]{"TB", "GB", "MB", "KB", "B"};
        if (value < 0) {
            throw new IllegalArgumentException("Invalid file size: " + value);
        }
        if (value == 0) { //если размер равен 0 B
            return "0";
        }
        for (int i = 0; i < dividers.length; i++) {
            if (value >= dividers[i]) {
                return format(value, dividers[i], units[i]);
            }
        }
        return null;
    }

    private static String format(final long value,
                                 final long divider,
                                 final String unit) {
        final double result =
                divider > 1 ? (double) value / (double) divider : (double) value;
        String strResult;
        if (unit.equalsIgnoreCase("KB") || unit.equalsIgnoreCase("MB")) {
            strResult = new DecimalFormat("#,##0.###").format(result) + " " + unit;
        } else {
            strResult = new DecimalFormat("#,##0.######").format(result) + " " + unit;
        }
        return strResult;
    }

    public static String format(Date value) {
        return format(value, FORMAT_DATETIME_FRONTEND);
    }

    public static String format(Date value, String defaultValue) {
        return format(value, FORMAT_DATETIME_FRONTEND, defaultValue);
    }

    public static String format(Date value, DateFormat dateFormat) {
        return format(value, dateFormat, null);
    }

    public static String format(Date value, DateFormat dateFormat, String defaultValue) {
        return value == null ? defaultValue : dateFormat.format(value);
    }

    public static Optional<Date> parseDate(String value, DateFormat dateFormat) {
        try {
            return Optional.ofNullable(dateFormat.parse(value));
        } catch (ParseException e) {
            return Optional.empty();
        }
    }

    public static XMLGregorianCalendar toCalendar(Date value) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(value);
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                                                                       .newXMLGregorianCalendar(calendar);
            //xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED); // without Z
            xmlGregorianCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
            return xmlGregorianCalendar;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static XMLGregorianCalendar toCalendarWithoutZone(Date value) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(value);
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                                                                       .newXMLGregorianCalendar(calendar);
            xmlGregorianCalendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED); // without Z
            xmlGregorianCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
            return xmlGregorianCalendar;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static XMLGregorianCalendar toCalendarMskWithMilliseconds(Date value) {
        try {
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(value);
            calendar.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
