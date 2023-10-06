import java.util.ArrayList;
import java.util.List;

class MergeIntervals{

    // https://leetcode.com/problems/merge-intervals/description/
    public static void main(String[] args) {
        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        int result[][]=merge(intervals); //[[1,6],[8,10],[15,18]]: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        for(int[] interval: result){
            for(int num:interval)
                System.out.print(num+" ");
            System.out.print(", ");
        }
    }

    //In this problem inputs will not be in sorted order we'll sort the inputs in aschnding order based on start of interval
    public static int[][] merge(int[][] intervals) {
        List<int[]> list=new ArrayList<>();

        //Sorting intervals
        for(int i=0;i<intervals.length-1;i++){
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[i][0] > intervals[j][0]){
                    int[] temp=intervals[i];
                    intervals[i]= intervals[j];
                    intervals[j]=temp;
                }
            }
        }

        int lastAdded=0; //index for lastly added elements to the list.
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){

            /**
             * If intervals merging merge current interval with lastly added.
             *  case 1: if end of lastly added is greater than current start and less than current end.
             *  case 2: if end of lastly added is greater than current end.
             */
            if(list.get(lastAdded)[1]>=intervals[i][0] && list.get(lastAdded)[1]<=intervals[i][1] || list.get(lastAdded)[1]>=intervals[i][1]){
                int max=Math.max(list.get(lastAdded)[1], intervals[i][1]);
                list.get(lastAdded)[1]=max;
            }else{ //If intervals not getting merged add the current interval
                list.add(intervals[i]);
                lastAdded++;
            }
        }
        int[][] result=new int[list.size()][2]; //create an array to send result in array format by adding list to result.
        for(int j=0;j<list.size();j++)
            result[j]=list.get(j);
        return result;
    }
}