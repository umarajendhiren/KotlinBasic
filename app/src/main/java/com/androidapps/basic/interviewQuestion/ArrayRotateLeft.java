package com.androidapps.basic.interviewQuestion;

public class ArrayRotateLeft {

    public static void main(String[] args) {
        RotateLeft(3);
    }
       /* public static void main(String[] args) {
            //Initialize array
            int [] arr = new int [] {1, 2, 3, 4, 5};
            //n determine the number of times an array should be rotated
            int n = 3;
            //Displays original array
            System.out.println("Original array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            //Rotate the given array by n times toward left
            for(int i = 0; i < n; i++){
                int j, first;
                //Stores the first element of the array
                first = arr[0];
                for(j = 0; j < arr.length-1; j++){
                    //Shift element of array by one
                    arr[j] = arr[j+1];
                }
                //First element of array will be added to the end
                arr[j] = first;
            }
            System.out.println();
            //Displays resulting array after rotation
            System.out.println("Array after left rotation: ");
            for(int i = 0; i< arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        }*/



        public static void RotateLeft(int numberOftimeShoulBeRotated){

            int[] array=new int[] {1,2,3,4,5};
            int first,j;


            System.out.print("Original Array");
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }

            for(int i=0;i<numberOftimeShoulBeRotated;i++){
                first=array[0];
                for(j=0;j<array.length-1;j++){

                    array[j]=array[j+1];
                }

                array[j]=first;
            }

            System.out.print("rotated Array");
            for(int i=0;i<array.length;i++){

                System.out.print(array[i]+" ");
            }
        }
    }


