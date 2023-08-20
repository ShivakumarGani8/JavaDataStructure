/* 
Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.
 
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
