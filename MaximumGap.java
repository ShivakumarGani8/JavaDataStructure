import java.util.Arrays;
/*
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
*/
public class MaximumGap {
    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(maximumGap(nums)); //O/P:3-> either (3,6) or (6,9) has the maximum difference 3
    }
    public static int maximumGap(int[] nums) {
        Arrays.sort(nums);//Sort array elements as specified in the question
        int maxDifference=0; //Intially set maxDifference as 0
        for(int i=1;i<nums.length;i++)//Sorting looping from 2nd element
            maxDifference=Math.max(maxDifference,(nums[i]-nums[i-1]));//Take diff between current and last element
        return maxDifference;
    }
}
