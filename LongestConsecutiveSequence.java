/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class LognestConsecutiveSequence{
    public static void main(String[] args) {
        int[] nums1={100,4,200,1,3,2};
        int[] nums2={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSequence(nums1)); //4
        System.out.println(longestConsecutiveSequence(nums2)); //9
    }

    //In this problem we'll follow a approach where, if num-1 exists will ignore it because it is not starting point of sequense. If not exists we'll loop it again by adding +1 each time if num+1 exists in each loop increase num & temp variables by 1 each time
    
    public static int longestConsecutiveSequence(int[] nums){
        int max=0;
        List<Integer> linkedList= new LinkedList<>(); 
        for(int num : nums)
        linkedList.add(num);

        Collections.sort(linkedList);
        for(int i=0;i<linkedList.size();i++){
            int temp=1;
            int num=linkedList.get(i);
            if(linkedList.contains(num-1)){ //If num-1 is exists ignore and continue
                continue;
            }while(linkedList.contains(++num)){ //If num+1 is exists keep looping to get length of the consecutive numbers by add +1 each time
                temp++;
            }
            max= Math.max(max, temp); //Get and store maximum consecutive numbers numbers
        }
        return max;
    }
}