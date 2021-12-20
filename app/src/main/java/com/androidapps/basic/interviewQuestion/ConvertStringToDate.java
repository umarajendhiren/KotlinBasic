package com.androidapps.basic.interviewQuestion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertStringToDate {

    public static void main(String[] args)throws Exception {
      StringToDate();

      DateToString();
    }

    private static void DateToString() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);
        System.out.println("Date Format with MM/dd/yyyy : "+strDate);

        formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd-M-yyyy hh:mm:ss : "+strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd MMMM yyyy : "+strDate);

        formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");
        strDate = formatter.format(date);
        System.out.println("Date Format with dd MMMM yyyy zzzz : "+strDate);

        formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
        strDate = formatter.format(date);
        System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z : "+strDate);

}

    private static void StringToDate() throws ParseException {
        /*We can convert String to Date in java using parse() method of DateFormat and SimpleDateFormat classes.*/

        //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);


        String sDate1="31/12/1998";
        String sDate2 = "31-Dec-1998";
        String sDate3 = "12 31, 1998";
        String sDate4 = "Thu, Dec 31 1998";
        String sDate5 = "Thu, Dec 31 1998 23:37:50";
        String sDate6 = "31-Dec-1998 23:37:50";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter3=new SimpleDateFormat("MM dd, yyyy");
        SimpleDateFormat formatter4=new SimpleDateFormat("E, MMM dd yyyy");
        SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date date1=formatter1.parse(sDate1);
        Date date2=formatter2.parse(sDate2);
        Date date3=formatter3.parse(sDate3);
        Date date4=formatter4.parse(sDate4);
        Date date5=formatter5.parse(sDate5);
        Date date6=formatter6.parse(sDate6);
        System.out.println(sDate1+"\t"+date1);
        System.out.println(sDate2+"\t"+date2);
        System.out.println(sDate3+"\t"+date3);
        System.out.println(sDate4+"\t"+date4);
        System.out.println(sDate5+"\t"+date5);
        System.out.println(sDate6+"\t"+date6);
    }
}
