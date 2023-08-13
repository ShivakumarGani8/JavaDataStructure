/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:
1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
*/
import java.util.ArrayList;
class DailyTemperatures{
    public static void main(String[] args) {
        int[] example1={73,74,75,71,69,72,76,73};
        int[] example2={30,40,50,60};
        int[] example3={30,60,90};
        System.out.println(daysToBeWaited(example1)); //[1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(daysToBeWaited(example2)); //[1, 1, 1, 0]
        System.out.println(daysToBeWaited(example3)); //[1, 1, 0]
    }
    public static ArrayList<Integer> daysToBeWaited(int[] temperatures){
        ArrayList<Integer> result=new ArrayList<>();//Temp arraylist to store the days
        for(int i=0;i<temperatures.length;i++){ //Traverse from 1st element
            int days=0; //If no element is greater in array days will be zero
            for(int j=i+1;j<temperatures.length;j++){ //Traversing through next elements
                if(temperatures[j]>temperatures[i]){ //If any of the next element(j) is greater than the current element(i)
                    days=j-i; //Substract days when the temperature is greater
                    break;
                }
            }
            result.add(days); //Add days to temp arraylist
        }
        return result;
    }
}