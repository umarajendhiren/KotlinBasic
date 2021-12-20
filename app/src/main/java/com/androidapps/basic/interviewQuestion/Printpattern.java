package com.androidapps.basic.interviewQuestion;

public class Printpattern {

    public static void main(String[] args) {
        /*

         *
         * *
         * * *
         * * * *

        * */

       // printRightTriangle();
       // printLeftTriangel();
        //pramid(5);
        DownwordRightTriangle(5);

    }

    private static void DownwordRightTriangle(int row) {
        for(int i=row-1;i>=0;i--){

            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pramid(int numberOfrow){
        int row=numberOfrow;

        for(int i=0;i<row;i++){

            for(int j=row-i;j>1;j--){

                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){

                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void printLeftTriangel() {
        //i for rows and j for columns
//row denotes the number of rows you want to print
        int i, j, row = 4;
//Outer loop work for rows
        for (i=0; i<row; i++)
        {
//inner loop work for space
            for (j=2*(row-i); j>=0; j--)
            {
//prints space between two stars
                System.out.print(" ");
            }
//inner loop for columns
            for (j=0; j<=i; j++ )
            {
//prints star
                System.out.print("* ");
            }
//throws the cursor in a new line after printing each line
            System.out.println();
        }

}

    private static void printRightTriangle() {

        int i, j, row=6;
//outer loop for rows
        for(i=0; i<row; i++)
        {
//inner loop for columns
            for(j=0; j<=i; j++)
            {
//prints stars
                System.out.print("* ");
            }
//throws the cursor in a new line after printing each line
            System.out.println();
        }

           }
}
