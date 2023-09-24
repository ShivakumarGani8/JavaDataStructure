/**
 Given an array nums of n integers, and target return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]. whose sum == target.
 https://leetcode.com/problems/4sum/
 */

import java.util.*;

public class SumOfFourNumbers {
    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
        
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {    
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){ 
            for(int j=i+1;j<nums.length;j++){
                int leftToRight=j+1;
                int rightToLeft=nums.length-1;
                while(leftToRight<rightToLeft){
                    long sumOfFour=(long)nums[i]+nums[j]+nums[leftToRight]+nums[rightToLeft];
                    if(sumOfFour==target){
                        List<Integer> subList=new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[leftToRight]);
                        subList.add(nums[rightToLeft]);
                        if(!list.contains(subList))
                        list.add(subList);
                        leftToRight++;
                    }else if(sumOfFour<target)
                        leftToRight++;
                    else
                    rightToLeft--;
                }
        }
    }
        return list;
    }
}
