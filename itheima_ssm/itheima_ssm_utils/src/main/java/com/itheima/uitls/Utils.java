package com.itheima.uitls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date string2date(String s,String patt) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(patt);

        Date date = sdf.parse(s);

        return date;


    }

    public static String date2string(Date date,String patt)  {

        SimpleDateFormat sdf = new SimpleDateFormat(patt);

        String s = sdf.format(date);

        return s;

    }
}
