package com.androidapps.basic.interviewQuestion;

public class ArraySepateZeroesAnd1s {
    public static void main(String[] args) {
        int arr[]={0,1,0,0,1,1,1,0,1};
        System.out.println("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        arr=separate0s1sSolution1(arr);
        System.out.println("n===========================");
        System.out.println("Solution 1");
        System.out.println("nArray after separating 0's and 1's : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("n===========================");
        System.out.println("Solution 2");
        arr=separate0s1sSolution2(arr);
        System.out.println("nArray after separating 0's and 1's : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        separateonesAnd2s();
    }

    //complexity [0]^n
    public static int[] separate0s1sSolution1(int arr[])
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
        return arr;
    }
    public static int[] separate0s1sSolution2(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            int left=0;
            int right=arr.length-1;
            while(arr[left]==0)
            {
                left++;
            }
            while(arr[right]==1)
            {
                right--;
            }

            if(left<right)
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        return arr;
    }
public static void separateonesAnd2s(){
    int[] arr=new int[]{1, 2, 2, 0, 0, 1, 2, 2, 1};

    int zero,ones,twos;

    zero=ones=twos=0;

    for(int i=0;i<arr.length;i++){
        if(arr[i]==0)
            zero++;
        else if(arr[i]==1)
            ones++;
        else if(arr[i]==2)
            twos++;
    }

    for(int i=0;i<zero;i++){
        arr[i]=0;}

    for(int i=zero;i<zero+ones;i++){
        arr[i]=1;}
    for(int i=zero+ones;i<zero+ones+twos;i++){
        arr[i]=2;}

    for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]+" ");
    }
}
}
