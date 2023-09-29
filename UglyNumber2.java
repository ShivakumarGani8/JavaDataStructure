/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.
*/

import java.util.TreeMap;

public class UglyNumber2 {
    static TreeMap<Integer,Integer> uglyNos=new TreeMap<Integer,Integer>(); //Keeping track for old records(Time optimization)
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(200)); //16200
        System.out.println(nthUglyNumber(500)); //937500
        
        System.out.println(nthUglyNumber(443)); //506250
        System.out.println(nthUglyNumber(762)); //96000000
        System.out.println(nthUglyNumber(200)); //16200

    }
    public static int nthUglyNumber(int n) {
        int num=1;
        int found=0;
        //If already nth ugly number exists returning nth number
        if(uglyNos.containsKey(n)){
            return (int)uglyNos.get(n);
        }
        //Take last added ugly number and position
        else if(uglyNos.size()>0){
            num= uglyNos.get(uglyNos.lastKey());
            found= uglyNos.lastKey()-found-1;
        }
        
        //Loop until we reach nth ugly number
        while(found<n){
            if(uglyNumber(num)){
                found++;
                uglyNos.put(found,num);
            }
            num++;
        }
        return --num;
    }
    
    public static boolean uglyNumber(int n){
        while(n>1){
            if(n%2==0)
            n/=2;
            else if(n%3==0)
            n/=3;
            else if(n%5==0)
            n/=5;
            else return false;
        }
        if(n==1) return true;
        else return false;
    }

}
