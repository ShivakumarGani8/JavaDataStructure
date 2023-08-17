/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
*/

public class TwoSum2 {
    public static void main(String[] args) {
        int[] example1={2,7,11,15};
        int target1=9;
        int[] example2={2,3,4};
        int target2=6;
        printTwoSum(example1,target1);
        printTwoSum(example2, target2);
    }
    //Let's divide array into two parts. where we'll add the elements from both the ends.
    //Case 1: If leftElement+rightElement<target will move to next element at LHS.
    //Case 2: If leftElement+rightElement> target will move to previous element at RHS.

    public static void printTwoSum(int[] numbers,int target){
        int leftElementIndex=0; // Variable for indexing from left to right
        int rightElmentIndex=numbers.length-1; // Variable for indexing from right to left
        while(leftElementIndex!=rightElmentIndex){ // Loop until both the elements not cross each other
            int sum=numbers[leftElementIndex]+numbers[rightElmentIndex];
            if(sum < target)
                leftElementIndex++;// If case 1
            else if(sum > target)
                rightElmentIndex--;// If case 2
            else{ // If target is reached
                System.out.println("["+(leftElementIndex+1)+", "+(rightElmentIndex+1)+"]");
                break;
            }
        }
    }
}
