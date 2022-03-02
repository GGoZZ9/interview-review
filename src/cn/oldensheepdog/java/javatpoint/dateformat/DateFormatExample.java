package cn.oldensheepdog.java.javatpoint.dateformat;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) throws Exception {
        Date currentDate = new Date();
        System.out.println("Current Date: "+currentDate);
        String dateToStr = DateFormat.getInstance().format(currentDate);
        System.out.println("Date Format using getInstance(): "+dateToStr);

        Date d = DateFormat.getDateInstance().parse("31 Mar, 2015");
        System.out.println("Date is: "+d);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate= formatter.format(date);
        System.out.println(strDate);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        Date date1 = new Date();
        Timestamp ts=new Timestamp(date1.getTime());
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter1.format(ts));

        Date date2 = new Date();
        Timestamp ts2=new Timestamp(date2.getTime());
        System.out.println(ts2);
    }
}
