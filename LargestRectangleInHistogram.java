/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
*/

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] example1={2,1,5,6,2,3};
        int[] example2={2,4};
        System.out.println(largestRectangleInHistogram(example1)); //10
        System.out.println(largestRectangleInHistogram(example2)); //4
    }
    public static int largestRectangleInHistogram(int[] input){
        int max=0;
        for(int i=0;i<input.length;i++){ //Let's devide an array of histogram into two half's (One will be traverse forward from i+1th index and one will traverse backward from i-1th index)
            int temp=0;
            int subRectangles=1; //Initally only one subRectangle from histogram
            for(int j=i+1;j<input.length;j++){ //Loop traversing forward from i+1th index 
                if(input[i]<=input[j]) //In each cases if the next element in greater or equal to ith element. Increase subRectangles by one each time
                subRectangles++;
                else break;
            }
            for(int j=i-1;j>=0;j--){ //Loop traversing backward from i-1th element
                if(input[i]<=input[j])//In each cases if the next element in greater or equal to ith element. Increase subRectangles by one each time
                subRectangles++; 
                else break;
            }
            temp=input[i]*subRectangles;
            max=Math.max(max, temp);
        }
        return max;
    }
}
