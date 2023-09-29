import java.util.*;
/* 
    Given with array of nums and sliding window length k. Find the maximum of the each sliding windows of length k.
*/

public class MaxSlidingWindow {
    public static void main(String[] args) {
       int[] nums = {1,3,-1,-3,5,3,6,7};
       int k = 3;
       int[] result= maxSlidingWindow(nums,k); //Output: [3,3,5,5,6,7] 
       /*
       Explanation: 
                Window position                Max
                ---------------               -----
                [1  3  -1] -3  5  3  6  7       3
                 1 [3  -1  -3] 5  3  6  7       3
                 1  3 [-1  -3  5] 3  6  7       5
                 1  3  -1 [-3  5  3] 6  7       5
                 1  3  -1  -3 [5  3  6] 7       6
                 1  3  -1  -3  5 [3  6  7]      7 
       */
       System.out.print("[");
       for(int maximus: result)
        System.out.print(maximus+",");
       System.out.println("]"); 
    }
    public static int[] maxSlidingWindow(int[] nums,int k){
        int[] result=new int[nums.length-k+1]; //According to the input the length of the result = nums.length-k+1

        //Our last sliding array will be starting from length-slidng array length
        // for(int i=0;i<=nums.length-k;i++){
        //     int slide=0; // starting index of sliding element
        //     int max=nums[i];
        //     while(slide<k){
        //         int element=nums[i+slide]; // Take element in each slide
        //         max= Math.max(max,element); //compare max
        //         slide++;
        //     }
        //     result[i]=max; //Adding elements to resultant array.
        // }

        //Our last sliding array will be starting from length-slidng array length
        for(int i=0;i<=nums.length-k;i++){
            int slide=0; // starting index of sliding element
            int max=nums[i];
            while(slide<k){
                int element=nums[i+slide]; // Take element in each slide
                max= Math.max(max,element); //compare max
                slide++;
            }
            result[i]=max; //Adding elements to resultant array.
        }

        // List<Integer> maxValues= new ArrayList<>();
        // for(int i=0;i<=nums.length-k;i++){
        //     int slide=0;
        //     int max=nums[i];
        //     while(slide<k){
        //         int element=nums[i+slide];
        //         max= Math.max(max,element);
        //         slide++;
        //     }
        //     maxValues.add(max);
        // }
        // int[] result= new int[maxValues.size()];
        // for(int i=0;i<maxValues.size();i++)
        //     result[i]=maxValues.get(i);
        // return result;
    
        return result;
    }
}
