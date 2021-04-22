package net.suncaper.demo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static Date getDateTime() throws ParseException {
        Date d = new Date();
        //System.out.println(d);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        //System.out.println("格式化后的日期：" + dateNowStr);

        return d;
    }
    public static String getDateMonth() throws ParseException {
        Calendar cal = Calendar.getInstance();

        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        return ""+year+"--"+month+"";

    }
}
