package com.androidapps.basic.interviewQuestion;

public class ArrayPrintLargestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40, 70, 50,5};
        int largest = arr[0], smallest = arr[0];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        System.out.println("largest element " + largest);

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < smallest)
                smallest = arr[j];
        }
        System.out.println("smallest element " + smallest);

//last element is the largest element after sort
        int temp;
        for(int k=0;k<arr.length;k++){
            for (int l=k+1;l<arr.length;l++){
                if(arr[k]>arr[l]) {
                    temp = arr[k];
                    arr[k]=arr[l];
                    arr[l]=temp;
                                    }
            }
        }
        System.out.println("largest element after sort " + arr[arr.length-1]);
        System.out.println("2nd largest element after sort " + arr[arr.length-2]);
        System.out.println("3rd largest element after sort " + arr[arr.length-3]);

        System.out.println("smallest element after sort " + arr[0]);
        System.out.println("second smallest element after sort " + arr[1]);//2nd element because index starts from 0
        System.out.println("3rd smallest element after sort " + arr[2]);

        findSmallestAndLargestElementInArray();

        }

    public static void  findSmallestAndLargestElementInArray(){
        //array of 10 numbers
        int arr[] = new int[]{12,56,76,89,100,343,21,234};

        //assign first element of an array to largest and smallest
        int smallest = arr[0];
        int largest = arr[0];

        for(int i=1; i< arr.length; i++)
        {
            if(arr[i] > largest)
                largest = arr[i];
            else if (arr[i] < smallest)
                smallest = arr[i];

        }
        System.out.println("Smallest Number is : " + smallest);
        System.out.println("Largest Number is : " + largest);
    }
}

