package com.flightsearch.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Cette Classe est utilisée pour récupérer ajouter a la date un numero des heures
 */
public class HelperTime {

    public static Date addHoursTime (Date currentTime, int timeAdd) {

        GregorianCalendar gc = new java.util.GregorianCalendar();
        gc.setTime(currentTime);
        gc.add(Calendar.HOUR, timeAdd);

        return gc.getTime();
    }
}
