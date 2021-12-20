package com.androidapps.basic.interviewQuestion;

import java.util.Scanner;

public class AmstrongNumber {


/*An Armstrong number is a positive m-digit number that is equal to the sum of the mth powers of their digits. It is also known as pluperfect, or Plus Perfect, or Narcissistic number. It is an OEIS sequence A005188. Let’s understand it through an example.

Armstrong Number Example1: 1^1 = 1,2^1 = 2,153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153

The first few Armstrong numbers between 0 to 999 are 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407

Note that there is no two-digit Armstrong number.
*/

    public static void main(String []args){
        //isAmstrong(153);

        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the limit");

        int n=scan.nextInt();

        for(int i=0;i<=n;i++){
            if(isAmstrong(i))
                System.out.println(i);


        }
    }

    public static boolean isAmstrong(int n){

        int temp,sum=0,last=0,digit=0;

        temp=n;
        while(temp>0){
            temp=temp/10;
            digit++;
        }

        temp=n;
        while(temp>0){
            last=temp%10;
            sum+=(Math.pow(last,digit));
            temp=temp/10;
        }

        if(sum==n){
            //System.out.println("Amstrong Number");
            return true;

        }

        else{
            // System.out.println("Not Amstrong Number");
            return false;
        }
    }


    //function to check if the number is Armstrong or not
   /* static boolean isArmstrong(int n) {
        int temp, digits = 0, last = 0, sum = 0;
//assigning n into a temp variable
        temp = n;
//loop execute until the condition becomes false
        while (temp > 0) {
            temp = temp / 10;
            digits++;
        }
        temp = n;
        while (temp > 0) {
//determines the last digit from the number
            last = temp % 10;
//calculates the power of a number up to digit times and add the resultant to the sum variable
            sum += (Math.pow(last, digits));
//removes the last digit
            temp = temp / 10;
        }
//compares the sum with n
        if (n == sum)
//returns if sum and n are equal
            return true;
//returns false if sum and n are not equal
        else return false;
    }

    //driver code
    public static void main(String args[]) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit: ");
//reads the limit from the user
        num = sc.nextInt();
        System.out.println("Armstrong Number up to " + num + " are: ");
        for (int i = 0; i <= num; i++)
//function calling
            if (isArmstrong(i))
//prints the armstrong numbers
                System.out.print(i + ", ");
    }*/
}
  /*  static boolean isArmstrong(int n)
    {
        int temp, digits=0, last=0, sum=0;
//assigning n into a temp variable
        temp=n;
//loop execute until the condition becomes false
        while(temp>0)
        {
            temp = temp/10;
            digits++;
        }
        temp = n;
        while(temp>0)
        {
//determines the last digit from the number
            last = temp % 10;
//calculates the power of a number up to digit times and add the resultant to the sum variable
            sum +=  (Math.pow(last, digits));
//removes the last digit
            temp = temp/10;
        }
//compares the sum with n
        if(n==sum)
//returns if sum and n are equal
            return true;
//returns false if sum and n are not equal
        else return false;
    }
    //driver code
    public static void  main(String args[])
    {
        int num;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number: ");
//reads the limit from the user
        num=sc.nextInt();
        if(isArmstrong(num))
        {
            System.out.print("Armstrong ");
        }
        else
        {
            System.out.print("Not Armstrong ");
        }
    }*/

