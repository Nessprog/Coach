package com.example.coach.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class MesOutils {

    private Date convertToStringDate(String uneDate){
        String expectedPattern = "EEE MMM dd hh:mm:ss 'GMT+00:00' yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
        try {
            Date date = formatter.parse(uneDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String convertDatetoString() {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date uneDate = null;
        return date.format(uneDate);
    }
}
