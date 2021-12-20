package com.androidapps.basic.interviewQuestion;

public class equalsMethod {


    public static void main(String[] args) {

        /*== operator ,is for reference comparison, i.e. both objects point to the same memory location
.equals() evaluates to the comparison of values in the objects*/
        String s1 = "Uma";
        String s2 = "kauthik";

        System.out.println(s1.equals(s2)); // false
        System.out.println(s1 == s2); // false

        String s3 = new String("newStrings3");
        String s4 = new String("newStrings3");
        System.out.println("\n1 - PRIMITIVES ");
        System.out.println(s3.equals(s4));//true
        System.out.println(s3 == s4);//false


        A a1 = new A();
        A a2 = new A();

        System.out.println("\n2 - OBJECT TYPES / STATIC VARIABLE");
        System.out.println(a1 == a2); // false
        System.out.println(a1.s == a2.s); // true
        System.out.println(a1.s.equals(a2.s)); // true

        B b1 = new B();
        B b2 = new B();

        System.out.println("\n3 - OBJECT TYPES / NON-STATIC VARIABLE");
        System.out.println(b1 == b2); // false
        System.out.println(b1.getS() == b2.getS()); // false
        System.out.println(b1.getS().equals(b2.getS())); // true


    }

    static final class A {
        // static
        public static String s;

        A() {
            this.s = new String("aTest");
        }
    }

    static final class B {
        private String s;

        B() {
            this.s = new String("aTest");
        }

        public String getS() {
            return s;
        }
    }
}
