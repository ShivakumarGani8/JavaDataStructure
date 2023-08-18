import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
*/

public class SumOfThreeNumbers {
    public static void main(String[] args) {
        int[] example1={-1,0,1,2,-1,-4};
        List<List<Integer>> list;
        list=getTriplets(example1);
        System.out.println(list); // [[-1, -1, 2], [-1, 0, 1]]

        int[] example2={0,1,1};
        list=getTriplets(example2);
        System.out.println(list); // []

        int[] example3={0,0,0};
        list=getTriplets(example3);
        System.out.println(list); // [[0,0,0]]

        
    }
    public static List getTriplets(int[] nums){
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int leftToRight=i+1;
            int rightToLeft=nums.length-1;
            int temp=0;
            while( leftToRight<rightToLeft ){
                int sumOfElements= nums[i]+nums[leftToRight]+nums[rightToLeft];
                if(sumOfElements==0){
                    List<Integer> subList=new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[leftToRight++]);
                    subList.add(nums[rightToLeft]);
                    if(!list.contains(subList))
                        list.add(subList);
                    
                }else if(sumOfElements<0){
                    leftToRight++;
                }else if(sumOfElements>0){
                    rightToLeft--;
                }
            }
        }
        return list;
    }
}
