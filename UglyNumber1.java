/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.
*/

public class UglyNumber1 {
    public static void main(String[] args) {
        System.out.println(isUgly(6)); //true: 6=2*3
        System.out.println(isUgly(1)); //true: 1 has no prime factors
        System.out.println(isUgly(14)); //false: 2*7
    }
    public static boolean isUgly(int n) {
        //Loop throughout until, n should become < 1 (i.e., A number is said to be prime factor only if the number is dividual by prime numbers)
        while(n>1){
            if(n%2==0)
                n/=2;
            else if(n%3==0)
                n/=3;
            else if(n%5==0)
                n/=5;
            else return false;
        }
        //If number exactly divided by prime numbers we can say it as ugly
        if(n==1) return true;
        //If number is not exactly divided by prime numbers
        else return false;
    }
}
