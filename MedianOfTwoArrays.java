import java.util.Arrays;

public class MedianOfTwoArrays {
    public static void main(String[] args) {
        int[] num1={1,2};
        int[] num2={3};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    //Merge both elements and get medians
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] arr=new double[nums1.length+nums2.length];
        int i=0;

        //Merging both the arrays
        for( ;i<nums1.length;i++)
            arr[i]=nums1[i];
        for( ;i<nums1.length+nums2.length;i++)
            arr[i]=nums2[i-nums1.length];

        //Sort merged array
        Arrays.sort(arr);

        //Mid of the array
        int mid=arr.length/2;
        //If merged array is of even length we'll have 2 medians
        if(arr.length%2==0){
            return (arr[mid]+arr[mid-1])/2;
        }
        //Else only one median
        else
            return arr[mid];
    }
}
