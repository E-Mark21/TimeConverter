package com.hfad.timeconverter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Converter {

    public Date convert(long time) {
        Calendar calendar1958 = new GregorianCalendar(1958, 0, 1);
        Calendar calendar1970 = new GregorianCalendar(1970, 0, 1);
        Date d1958 = calendar1958.getTime();
        Date d1970 = calendar1970.getTime();
        Date tekyschayaData = new Date();
        long v = tekyschayaData.getTime() - calendar1970.getTimeInMillis();
        long popravka = 378702000000L;
        long vvodDaty = 1969553200777L;
        long ms = tekyschayaData.getTime() - calendar1958.getTimeInMillis();
        Date date1 = new Date(vvodDaty - popravka);
        return date1;
    }
}
