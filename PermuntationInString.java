/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.
*/

import java.util.*;

class PermuntationInString {
    public static void main(String[] args) {
        String s1 ="adc",s2 ="dcda";
        System.out.println(checkInclusion(s1,s2)); //true :String s2 contains a permuntation "cda"
    }

    //Here we'll create two hasmaps and add characters of s1 two one of them. Then, traverse across the s2 characters where, traversing each time should == length of s1 and add elements two another hashmap if both are equal return true. Else return false in the end.
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> string1Chars=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            if(string1Chars.containsKey(ch)){
                int value=string1Chars.get(ch);
                value++;
                string1Chars.put(ch, value);
            }else{
                string1Chars.put(ch,1);
            }
        }
        
        for(int i=0;i<=s2.length()-s1.length();i++){
            Map<Character,Integer> string2Chars=new HashMap<>();
            for(int j=i;j<i+s1.length();j++){
                char ch=s2.charAt(j);
                if(string2Chars.containsKey(ch)){
                    int value=string2Chars.get(ch);
                    value++;
                    string2Chars.put(ch, value);
                }else{
                    string2Chars.put(ch,1);
                }
            }
            if(string2Chars.equals(string1Chars))
                return true;
        }
        return false;
    }
}
