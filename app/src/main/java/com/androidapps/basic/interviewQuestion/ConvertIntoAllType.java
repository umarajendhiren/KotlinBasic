package com.androidapps.basic.interviewQuestion;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertIntoAllType {
    public static void main(String[] args) throws ClassNotFoundException {
       // StringToChar();
       // charToString();

        //StringToObject();
        //objectToString();

        //intToLong();
        //longToInt();
        
       // intToDouble();
        //doubleToInt();

        //charToInt();
        //intToChar();

       // StringToBoolean();
       // booleanToString();

       // DateToTimeStamp();
        //timeStampToDate();

       // binaryToDecimal();
        //decimalToBinary();

        //hexToDecimal();
        //DecimallToHex();

       // octalToDecimal();
        decimalToOctal();

    }

    private static void decimalToOctal() {
        //Using the predefined Integer.toOctalString() method
//to convert decimal value into octal
        System.out.println(Integer.toOctalString(8));
        System.out.println(Integer.toOctalString(19));
        System.out.println(Integer.toOctalString(81));
    }

    private static void octalToDecimal() {
        System.out.println(Integer.parseInt("121",8));
        System.out.println(Integer.parseInt("23",8));
        System.out.println(Integer.parseInt("10",8));
    }

    private static void DecimallToHex() {
        System.out.println(Integer.toHexString(10));
        System.out.println(Integer.toHexString(15));
        System.out.println(Integer.toHexString(289));
    }

    private static void hexToDecimal() {
        String hex="a";


        int decimal=Integer.parseInt(hex,16);
        System.out.println(decimal);
    }

    private static void decimalToBinary() {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(21));
        System.out.println(Integer.toBinaryString(31));
    }

    private static void binaryToDecimal() {
        System.out.println(Integer.parseInt("1010",2));
        System.out.println(Integer.parseInt("10101",2));
        System.out.println(Integer.parseInt("11111",2));
    }

    private static void timeStampToDate() {
        /*We can convert Timestamp to Date in java using constructor of java.util.Date class.

The constructor of Date class receives long value as an argument. So, you need to convert Timestamp object into long value using getTime() method of java.sql.Timestamp class.

Let's see the constructor of Date class and signature of getTime() method.*/

        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=new Date(ts.getTime());
        System.out.println(date);

        /*The Timestamp class extends Date class. So, you can directly assign instance of Timestamp class into Date. In such case, output of Date object will be like Timestamp.
        But, it is not suggested by Java Doc because you may loose the milliseconds or nanoseconds of data.*/
        Date date1=ts;
        System.out.println(date1);
    }

    private static void booleanToString() {
        /*We can convert boolean to String in java using String.valueOf(boolean) method.

Alternatively, we can use Boolean.toString(boolean) method which also converts boolean into String.*/
        boolean b1=true;
        boolean b2=false;
        String s1=String.valueOf(b1);
        String s2=String.valueOf(b2);
        System.out.println(s1);
        System.out.println(s2);

        String s3=Boolean.toString(b1);
        String s4=Boolean.toString(b2);
        System.out.println(s3);
        System.out.println(s4);
    }

    private static void DateToTimeStamp() {
        /*We can convert Date to Timestamp in java using constructor of java.sql.Timestamp class.

The constructor of Timestamp class receives long value as an argument. So you need to convert date into long value using getTime() method of java.util.Date class.

You can also format the output of Timestamp using java.text.SimpleDateFormat class.*/
        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        System.out.println(ts);

        //You can format the Timestamp value using SimpleDateFormat class


        Timestamp ts1=new Timestamp(date.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(ts1));
    }

    private static void StringToBoolean() {
        /*We can convert String to boolean in java using Boolean.parseBoolean(string) method.

         To convert String into Boolean object, we can use Boolean.valueOf(string) method which returns instance of Boolean class.
         To get boolean true, string must contain "true". Here, case is ignored.
         So, "true" or "TRUE" will return boolean true. Any other string value except "true" returns boolean false.*/

        String s1="true";
        String s2="TRue";
        String s3="ok";
        boolean b1=Boolean.parseBoolean(s1);
        boolean b2=Boolean.parseBoolean(s2);
        boolean b3=Boolean.parseBoolean(s3);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Boolean b4=Boolean.valueOf(s1);
        Boolean b5=Boolean.valueOf(s2);
        Boolean b6=Boolean.valueOf(s3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);

    }

    private static void intToChar() {
        /*We can convert int to char in java using typecasting. To convert higher data type into lower, we need to perform typecasting.
         Here, the ASCII character of integer value will be stored in the char variable.
         To get the actual value in char variable, you can add '0' with int variable. Alternatively, you can use Character.forDigit() method.*/

        int a=65;
        char c=(char)a;
        System.out.println(c);

        /*But if you store 1, it will store ASCII character of given number which is start of heading which is not printable.
         So it will not print anything on the console.*/

        int a1=1;
        char c1=(char)a1;
        System.out.println(c1);

        /*If you add '0' with int variable, it will return actual value in the char variable. The ASCII value of '0' is 48. So,
        if you add 1 with 48, it becomes 49 which is equal to 1. The ASCII character of 49 is 1.*/
        int a2=1;
        char c2=(char)(a2+'0');
        System.out.println(c2);

        /*If you store integer value in a single quote, it will store actual character in char variable.*/
        int a3='1';
        char c3=(char)a3;
        System.out.println(c3);

        /*To get the actual value, you can also use Character.forDigit() method.*/
        int REDIX=10;//redix 10 is for decimal number, for hexa use redix 16
        int a4=1;
        char c4=Character.forDigit(a4,REDIX);
        System.out.println(c4);

        //To get the hexa value, use redix 16 in Character.forDigit() method.
        int REDIX1=16;//redix 16 is for Hexadecimal value
        int a5=10;
        char c5=Character.forDigit(a5,REDIX1);
        System.out.println(c5);
    }

    private static void charToInt() {
       /* We can convert char to int in java using various ways.
        If we direct assign char variable to int, it will return ASCII value of given character.
        If char variable contains int value, we can get the int value by calling Character.getNumericValue(char) method.
        Alternatively, we can use String.valueOf(char) method.*/

        char c='a';
        char c2='1';
        int a=c;
        int b=c2;
        System.out.println(a);
        System.out.println(b);

        int intValue=Character.getNumericValue(c2);
        System.out.println(intValue);

        int intValue1=Integer.parseInt(String.valueOf(c2));
        System.out.println(intValue1);
    }

    private static void doubleToInt() {
        double d=10.5;
        int i=(int)d;
        System.out.println(i);

        //We can convert Double object to int by intValue() method of Double class
        Double d1=new Double(10.5);
        int i1=d1.intValue();
        System.out.println(i1);
    }

    private static void intToDouble() {
        int i=200;
        double d=i;
        System.out.println(d);

        //We can convert int value to Double object by instantiating Double class or calling Double.valueOf() method.

        Double d1= new Double(i);//first way
        Double d2=Double.valueOf(i);//second way
        System.out.println(d1);
        System.out.println(d2);
    }

    private static void longToInt() {
        /*We can convert long to int in java using typecasting.
        To convert higher data type into lower, we need to perform typecasting.

       Typecasting in java is performed through typecast operator (datatype).

       Here, we are going to learn how to convert long primitive type into int and Long object into int.*/

        long l=500;
        int i=(int)l;
        System.out.println(i);

        //We can convert Long object to int by intValue() method of Long class.
        Long l1= new Long(10);
        int i1=l1.intValue();
        System.out.println(i1);
    }

    private static void intToLong() {
        /*We can convert int to long in java using assignment operator.
         There is nothing to do extra because lower type can be converted to higher type implicitly.

         It is also known as implicit type casting or type promotion.*/

        int i=200;
        long l=i;
        System.out.println(l);


        /*We can convert int value to Long object by instantiating Long class or calling Long.valueOf() method.*/
        int i1=100;
        Long l1= new Long(i1);//first way
        Long l2=Long.valueOf(i1);//second way
        System.out.println(l1);
        System.out.println(l2);
    }

    private static void objectToString() {
        //We can convert Object to String in java using toString() method of Object class or String.valueOf(object) method.

       /* Emp e=new Emp();
        String s=e.toString();
        String s2=String.valueOf(e);
        System.out.println(s);
        System.out.println(s2);*/
    }

    private static void StringToObject() throws ClassNotFoundException {
        /*We can convert String to Object in java with assignment operator. Each class is internally a child class of Object class. So you can assign string to Object directly.*/

        String s="hello";
        Object obj=s;
        System.out.println(obj);

        /*Let's see the simple code to convert String to Class object in java using Class.forName() method.
        The Class.forName() method returns the instance of Class class which can be used to get the metadata of any class.*/
        Class c=Class.forName("java.lang.String");
        System.out.println("class name: "+c.getName());
        System.out.println("super class name: "+c.getSuperclass().getName());
    }

    private static void charToString() {
        /*We can convert char to String in java using String.valueOf(char) method of String class and Character.toString(char) method of Character class.*/
        char c='S';
        String s=String.valueOf(c);
        System.out.println("String is: "+s);

        char c1='M';
        String s1=Character.toString(c1);
        System.out.println("String is: "+s1);


    }

    private static void StringToChar() {
        String s="hello";
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            System.out.println("char at "+i+" index is: "+c);
        }
    }
}
