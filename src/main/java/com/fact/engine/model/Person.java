package com.fact.engine.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person {
    private Map<String, String> data;

    public Person(String address, String birthday, String phone) {
        data = new HashMap<>();
        data.put("address", address);
        data.put("age", getAge(birthday));
        data.put("phone", phone);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date birthDate = new Date();
        try {
            birthDate = sdf.parse(birthday);
        } catch (ParseException e) {
            System.out.println("Error parsing date.");
        }
        data.put("birthday", getBirthday(birthDate));
    }

    public String get(String input) {
        if (data.containsKey(input)) {
            return data.get(input);
        } else {
            return "";
        }
    }

    private String getAge(String birthday) {
        String[] dateParts = birthday.split("/");
        Integer year = Integer.valueOf(dateParts[2]);
        Integer month = Integer.valueOf(dateParts[0]);
        Integer day = Integer.valueOf(dateParts[1]);
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        return String.valueOf(Period.between(birthDate, now).getYears());
    }

    private String getBirthday(Date birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        return sdf.format(birthday);
    }
}
