public class TwoSum2 {
    public static void main(String[] args) {
        int[] example1={2,7,11,15};
        int target1=9;
        int[] example2={2,3,4};
        int target2=6;
        printTwoSum(example1,target1);
        printTwoSum(example2, target2);
    }
    public static void printTwoSum(int[] numbers,int target){
        int sum=0;
        int leftToRight=0;
        int rightToLeft=numbers.length-1;
        while(true){
            sum=numbers[leftToRight]+numbers[rightToLeft];
            if(sum < target)
                leftToRight++;
            else if(sum > target)
                rightToLeft--;
            else{
                System.out.println("["+(leftToRight+1)+", "+(rightToLeft+1)+"]");
                break;
            }
        }
    }
}
