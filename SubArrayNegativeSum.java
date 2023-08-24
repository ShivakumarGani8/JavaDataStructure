/*
Given an array of  integers, find and print its number of negative subarrays on a new line.

*/
import java.util.Scanner;

public class SubArrayNegativeSum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n= scan.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++)
            arr[i]=scan.nextInt();
        System.out.println("Total subarrays having negative sum: "+totalNegativeSubArrays(arr));
    }
    
    public static int totalNegativeSubArrays(int[] arr){
        int n=arr.length;
        int count=0;
        //No of elements in each subarray
        for(int elements=1;elements<=n;elements++){            
            //Accessing array
            for(int j=0;j<=n-elements;j++){
                int sum=0;
                //Adding sub array elements
                for(int k=j;k<j+elements;k++){
                    sum+=arr[k];
                }
                //Increase count if sum is negative num
                if(sum<0)
                count++;
            }
        }
       return count;
    }
}
