import javax.swing.text.AbstractDocument.LeafElement;

/* 
11. Container With Most Water
Medium
26.1K
1.4K
Companies
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 
*/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] example1={1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater(example1)); // 49
        int[] example2={1,1};
        System.out.println(containerWithMostWater(example2)); //1
    }

    //In this problem we will travers containers from both the ends. Here the conatainer can only hold water whose height is minimum between the two conainers.
    //Case 1: If container at left is small it can only hold that much volume of water. Then calculate the amount of water it can store and shift to next container.
    //Case 2: If container at right is small it can only hold that much volume of water. Then calculate the amount of water it can store and shift to next container.
    public static int containerWithMostWater(int[] containers){
        int mostWater=0;
        int leftToRight=0; //To traverse from left to right
        int rightToLeft=containers.length-1; // To travers from right to left
        int temp=0;
        while(leftToRight<rightToLeft){ // Will break the loop when both the containers crossess each other
            int currentVolume=0; //
            int leftContainer=containers[leftToRight]; //Height of left container
            int rightContainer=containers[rightToLeft]; //Height of right container
            int spaceBetweenContainers=rightToLeft-leftToRight; //Space between both the contaiers
            if(leftContainer<rightContainer){
                currentVolume=leftContainer*spaceBetweenContainers;
                leftToRight++; // If left conatainer is small calculate volume of water it can hold and shift to next element
            }else{
                currentVolume=rightContainer*spaceBetweenContainers;
                rightToLeft--;  // If right conatainer is small calculate volume of water it can hold and shift to next element
            }
            mostWater=Math.max(mostWater, currentVolume);
        }
        return mostWater;
    }
    
}
