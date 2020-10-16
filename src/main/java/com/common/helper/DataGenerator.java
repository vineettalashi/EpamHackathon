package com.common.helper;

import com.github.javafaker.Faker;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Currency;

public class DataGenerator {


    public static Faker faker = new Faker();
    public static LocalDate localDate = LocalDate.now();
    public static String datePattern = "yyyy-MM-dd";

    public static String generateFullName() {
        return faker.name().fullName();
    }

    public static String generateTodaysDate() {

        return localDate.format(DateTimeFormatter.ofPattern(datePattern));
    }

    public static String generatePreviousDate(long amountOfDaysToSubtract) {

        return localDate.minus(amountOfDaysToSubtract, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
    }

    public static String generateFutureDate(long amountOfDaysToAdd) {

        return localDate.plus(amountOfDaysToAdd, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
    }

    public static String generateWeekDayTradeDate() {

        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return localDate.plus(2, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return localDate.plus(1, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else {
            return generateTodaysDate();
        }
    }

    public static String generateWeekDayValueDateAhead(String tradeDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        localDate = LocalDate.parse(tradeDate, formatter);
        localDate = localDate.plus(2, ChronoUnit.DAYS);

        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return localDate.plus(2, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return localDate.plus(1, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else {
            return localDate.toString();
        }
    }

    public static String generateWeekDayValueDateBehind(String tradeDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        localDate = LocalDate.parse(tradeDate, formatter);
        localDate = localDate.minus(2, ChronoUnit.DAYS);

        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return localDate.plus(2, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else if (localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return localDate.plus(1, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(datePattern));
        } else {
            return localDate.toString();
        }
    }

    private static String getFormatterString(String dateString, String dateStringPrePattern, String dateStringPostPattern) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(dateStringPrePattern)).format(DateTimeFormatter.ofPattern(dateStringPostPattern));
    }

    public static String generateWeekEnd() {
        while (localDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
            localDate = localDate.plus(1, ChronoUnit.DAYS);
        }
        return localDate.format(DateTimeFormatter.ofPattern(datePattern));
    }

    public static String generateValidCustomer() {
        return "PLUTO1";
    }

    public static String generateInValidCustomer() {
        return faker.name().firstName();
    }

    public static String generateValidLegalEntity() {
        return "CSZurich";
    }

    public static String generateInValidLegalEntity() {
        return faker.name().firstName();
    }

    public static String generateCurrencyCode() {
        return faker.currency().code();
    }

    public static String generateCurrencyCodePair() {
        String currencyPair;
        String currency1 = generateCurrencyCode();
        if (isValidCurrency(currency1)) {
            System.out.println("ISO 4217 currecny code was generated : " + currency1);
        } else {
            generateCurrencyCodePair();
        }
        String currency2 = generateCurrencyCode();
        if (isValidCurrency(currency2)) {
            System.out.println("ISO 4217 currecny code was generated : " + currency2);
        } else {
            generateCurrencyCodePair();
        }
        currencyPair = currency1 + currency2;
        return currencyPair;
    }

    public static boolean isValidCurrency(String countryCode) {
        boolean valid = false;
        try {
            Currency c1 = Currency.getInstance(countryCode);
            System.out.println(c1.getDisplayName());
            valid = true;
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return valid;
    }

    public static String generateInvalidProductType() {
        return "REVERSE";
    }
}
