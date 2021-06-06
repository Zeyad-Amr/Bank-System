package com.bank.atm.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {
    public static java.sql.Date getSqlDate(LocalDate localDate) {

        return java.sql.Date.valueOf(localDate);

    }

    public static String getRandomNumber(int min, int max) {
        Random r = new Random();
        int rand1 = (int) r.nextInt(max - min) + min;
        int rand2 = (int) r.nextInt(max - min) + min;
        return Integer.toString(rand1) + Integer.toString(rand2);
    }

    public static LocalDate toLocaldate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }
}
