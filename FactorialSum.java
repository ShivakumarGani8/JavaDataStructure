import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Factorial Sum
 A number is said to be special number if, sum-of-digits of number is less than<10. And factorial of sum-of-digits contains all the digits in the number.
 Step 1: A sum-of-digits of number until it become less than 10.
 Step 2: Once sum-of-digits<10, find the factorial of number.
 Step 3: If factorial of sum-of-digits contains all the digits in the number. then, the number is said to be special number.

Input: given N length of array and next lines follwed by elements of array
Outpt: print the total numbers of special number in the array

Test cases
Example 1:
    lengthofArray = 9
    Elements of array= 833 355 243 851 360 145 214 750 112
    Expected O/P: 1 
    Explanation:360 is the only special number
                3+6+0 <10 sumOfDigits=9
                factorial of sumOfDigits=362880 which contains all the digits in number 360.

Example 2:
    lengthofArray = 9
    Elements of array= 264 653 122 780 396 727 797 419 211
    Expected O/P: 1 Explanation: 122 is the only special number

Example 3:
    lengthofArray = 8
    Elements of array= 310 663 845 257 561 748 735 717
    Expected O/P: 0 Explanation:There are no special numbers
*/
public class FactorialSum {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int lengthOfArray=scan.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<lengthOfArray;i++)
            list.add(scan.nextInt());
        System.out.println(factorialSum(lengthOfArray, list));;
    }

    public static int factorialSum(int array_length,List<Integer> arr){
        int specialNumbers=0; //To store total numbers of special numbers
        for(int num: arr){
            int sumOfDigits= sumOfDigits(num);
            while(sumOfDigits>9){ //Find sum-of-digits till it becomes <10
                sumOfDigits=sumOfDigits(sumOfDigits);
            }
            int factorial=factorial(sumOfDigits); //Factorial of number
            if(isSpecialNumber(num,factorial)){ // If number is specialNumber
                specialNumbers++;
            }
        }
        return specialNumbers;
    }
    //Method returns sumOfDigits
    public static int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            num /= 10;
            sum +=digit;
        }
        return sum;
    }
    //Method returns factorial of given number
    public static int factorial(int num){
        int factorial=1;
        for(int i=1;i<=num;i++)
            factorial *=i;
        return factorial;
    }
    //Checks whether the number is special or not
    public static boolean isSpecialNumber(int num,int fact){
        String numString= Integer.toString(num);
        String factString= Integer.toString(fact);
        for(int i=0;i<numString.length();i++){
            if(factString.contains(Character.toString(numString.charAt(i))))
                continue;
            else
                return false;
        }
        return true;
    }
    
}
