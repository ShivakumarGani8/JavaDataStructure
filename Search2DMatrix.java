/*
You are given with 2D matrix of (mXn) where, all the elements are in sorted order.
-Search the target element in the array if target found return true. else return fasle.
*/
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=64;
        System.out.println(serachTarget(matrix,target));
    }
    /*
        ->In this example the input 2D matrix is sorted
        -We have to divide matrix into mainArray(2X2) and subArray(1XN) where n is the length of subArray.
        ->By using binary serach we'll search is the element in the range or not. if, it is in  the range we'll break the traversing in mainArray.
        ->Once we break the loop we'll take concider midMainArray and travere across each   elements using binary-search.
    */
    public static boolean serachTarget(int[][] matrix,int target){
        int startMainArray=0;//Starting for 2D matrix(1st row)
        int endMainArray=matrix.length-1;//End for 2D matrix(last row)
        int midMainArray=0;//Mid element for 2D matrix(middle row)

        int startSubArray=0; //for subArray start(mX0)
        int endSubArray=matrix[0].length-1;//For subArray end(m X lastElement in subArray)

        //Find subArray where the target we'll be in specified range using binary search
        while(startMainArray<=endMainArray){
            midMainArray=(startMainArray+endMainArray)/2;
            if(target>=matrix[midMainArray][0] && target<=matrix[midMainArray][matrix[0].length-1]){
                break;
            }
            else if(target<matrix[midMainArray][0]){
                endMainArray=midMainArray-1;
            }else
                startMainArray=midMainArray+1;
        }

        //Apply binary search once we find the subArray
        while(startSubArray<=endSubArray){
            int midSubArray=(startSubArray+endSubArray)/2;
            if(matrix[midMainArray][midSubArray]==target)
                return true;
            else if(matrix[midMainArray][midSubArray]>target)
                endSubArray=midSubArray-1;
            else
                startSubArray=midSubArray+1;
        }
        return false;
    }
}
