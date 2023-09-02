/*
Given an unsorted integer array nums, return the smallest missing positive integer.
Positive integers starts from 1-N.
If all elements from 1-N present in the array return N+1;
*/

import java.util.*;
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums={1,2,0};
        System.out.println(firstMissingPositive(nums));//O/P: 3 . The smallest missing positive number is 3
    }

    public static int firstMissingPositive(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i: nums){//Adds only positve elements to the set
            if(i<=0)
            continue;
            else set.add(i);
        }
        int maxPositive=0; //Concider 0 as the first missing positive integer
        if(set.size()>0){//If positive numbers exists in tree
            maxPositive= set.last(); //Stores maximum element
            for(int i=1;i<=maxPositive;i++)
                if(set.contains(i))//Checks do we have each positive numbers from 1.
                    continue;
                else return i; //If number not exists return current positive number
        }
        return (maxPositive+1);//If all elements exists return maxPositive+1(Next element in the arrary)
    }
}
