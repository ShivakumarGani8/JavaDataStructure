    //https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));//6: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
    }

    //In this solution there will no wall in the both left and right side's.
    //The total water stored between two walls will be -> (minimum height between left and right) - (current height).
    public static int trap(int[] height) {
        int totalWater=0; //End result total Water trapped.
        int maxIndexRight=0;
        int maxLeft=0; // Maximum height to the left of current height.
        int maxRight=0; // Maximum height to the right of current height.

        //Looping throught the each height's.
        for(int i=1;i<height.length-1;i++){
            int lastElement=height[i-1]; //Store last element
            // We'll only change the max height at the left side if and only if the last height is larger than the previous recorded.
            if(lastElement>maxLeft)
                maxLeft=lastElement;

             // We'll only change the max height at the right side if and only if the indexing crossess previous maximum index recorded.
            if(i>=maxIndexRight){
                maxRight=0;
                for(int right=i+1;right<height.length;right++){
                if(maxRight<height[right]){
                    maxRight=height[right];
                    maxIndexRight=right;
                }
                }
            }
            int minOfMax=Math.min(maxLeft,maxRight);
            if(minOfMax-height[i]>0) // If minimum height between two walls and current height can store water.
                totalWater+=minOfMax-height[i];
        }
        return totalWater;
    }
}
