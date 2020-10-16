package com.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;

import com.github.javafaker.Faker;

public class TestUtils {
	
	public static Faker faker = new Faker();
    public static LocalDate localDate = LocalDate.now();
    
    public static String generateFullName() {
        return faker.name().fullName();
    }

    public static String generateTodaysDate() {

        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    
	public static void main(String[] args) {
		System.out.println(generateFullName());
		System.out.println(generateTodaysDate());
		System.out.println(Currency.getInstance(faker.currency().code()).getDisplayName());
	}

}
