import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
You are given a 2D array. An hourglass in an array is a portion shaped like this:
            a b c
              d
            e f g
The sum of an hourglass is the sum of all the numbers within it. The sum for the
-Output= print the largest sum among all the hourglasses in the array.
*/
class HourGlass{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> arr = new ArrayList<>();
        System.out.println("Enter elements of Hour glass");
        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }
            arr.add(arrRowItems);
        }
        bufferedReader.close();
        int hourGlassSum=0;
        int max=-100;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                hourGlassSum= arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2)+arr.get(i+1).get(j+1)+arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2);
            if(hourGlassSum>=max){
                max=hourGlassSum;
            }
            }          
        }
        System.out.println("Maximum sum of hourglasses :"+max);
    }
}