package com.androidapps.basic.interviewQuestion;

public class ArrayFindPairWhoseSumIsClosestToX {

    public static void main(String[] args) {
       int array[]={-40,-5,1,3,6,7,8,20};
        findPairWithClosestToXBruteForce(array,5);
        findPairsWithSumEqualsToXBruteForce(array,5);

       int arr[] = {0,1,0,0,1,1,1,0,1};
        separate0s1sSolution1(arr);
    }
    public static void findPairWithClosestToXBruteForce(int arr[],int X)
    {
        if(arr.length<2)
            return;
        // Suppose 1st two element has minimum diff with X
        int minimumDiff=Math.abs(arr[0]+arr[1]-X);
        int pair1stIndex=0;
        int pair2ndIndex=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int tempDiff=Math.abs(arr[i]+arr[j]-X);

                if(tempDiff< minimumDiff)
                {
                    pair1stIndex=i;
                    pair2ndIndex=j;
                    minimumDiff=tempDiff;
                }
            }
        }
        System.out.println(" The pair whose sum is closest to X using brute force method: "+arr[pair1stIndex]+" "+ arr[pair2ndIndex]);
    }
    public static void findPairsWithSumEqualsToXBruteForce(int arr[], int X) {
        if (arr.length < 2)
            return;

        System.out.println("The pair whose sum is equal to 15 using brute force method: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tempSum = arr[i] + arr[j];

                if (tempSum == X) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }

    public static void separate0s1sSolution1(int arr[])
    {
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0)
            {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            arr[i]=0;
        }
        for (int i = count; i < arr.length; i++) {
            arr[i]=1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }

}
