package com.androidapps.basic.interviewQuestion;

public class LargestPrimeFactor {
    /**
     * Java program to find and print largest prime factor of an integer number. for * example number 6 has two prime factors 2 and 3, but 3 is the largest prime * factor of 6. input 15 output 5 * * @author Javin Paul
     */
/*Solution: As we learned a number is called a prime factor if it is a prime number and it can divide the number exactly. Another property of prime factor is that if we keep dividing the number by prime factor then it will either fully divide the number or produce another prime factor e.g. if we need to find the prime factors of 16 then starting from 2 if keep dividing, eventually dividend become 1, so 2 is the only prime factor of 16.

On the other hand, if we need to find a prime factor of 15, then we first try to divide it by 2, but since its not divisible by 2, we move to the next number which is 3. Since 3 can divide 15, it produces another prime number 5, now 5 is not divisible by anything other than 5, so 3 and 5 become a prime factors of 15.

Algorithm: In our program, we have used the same logic. We start with 2, the smallest prime number and try to divide the number if the number is divisible then we keep dividing it by same number until its not divisible anymore. Now we move to next number, the largest number which is able to fully divide the input is our largest prime factor. This would be more clear when you see the actual program.

Read more: https://javarevisited.blogspot.com/2015/03/how-to-find-largest-prime-factor-of.html#ixzz73hsXPHqs*/
    public static void main(String args[]) {
        System.out.printf("Largest prime factor of number '%d' is %d %n", 6, largestPrimeFactor(6));
        System.out.printf("highest prime factor of number '%d' is %d %n", 15, largestPrimeFactor(15));
        System.out.printf("Biggest prime factor of number '%d' is %d %n", 392832, largestPrimeFactor(392832));
        System.out.printf("Largest prime factor of number '%d' is %d %n", 1787866, largestPrimeFactor(1787866));

        primeFactor(6);
    }

    /**
     * @return largest prime factor of a number
     */
    public static int largestPrimeFactor(long number) {
        int i;
        long copyOfInput = number;
        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i;
                i--;
            }
        }
        return i;
    }

    public static void primeFactor(long number) {
        int largestPrimeFactor = 1;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                largestPrimeFactor = i;
            }
        }

        System.out.println(largestPrimeFactor);
    }
}

  /*  Output:
    Largest prime
    factor of
    number '6'is 3
    highest prime
    factor of
    number '15'is 5
    Biggest prime
    factor of
    number '392832'is 31
    Largest prime
    factor of
    number '1787866'is 893933*/


