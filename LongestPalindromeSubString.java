/*
Given a String of length n. return the longest palindrome sub string in given string.
*/


public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String str = "abaabba";
        System.out.println(longestPalindrome(str)); // Output: baab or abba both are the longest palindromes in the given String.
    }

    /*
    Let's concider a string variable longest as the longest palindrome in the string.
    -Take substring using loop(The ending index we can define as the starting index + length of longest variable).
    -In while loop traverse substring from both the ends. if both starting and ending characters equal contine for next loop. else, break looping of current substring and take next substring.
    */
    public static String longestPalindrome(String str){
        String longest=""; //To store longest substring
        for(int i=0;i<str.length();i++){
            for(int j=i+longest.length();j<str.length();j++){
                String subString=str.substring(i,j+1);
                int start=0;
                int end=subString.length()-1;
                while(start<end){ //To loop substring from both the ends.
                    if(subString.charAt(start)==subString.charAt(end)){
                        start++;
                        end--;
                        continue;
                    }       
                    else
                        break; 
                }
                if(start==end || start>end) //Concider current substring as longest if starting and ending index are equal or both the index's crossed each other.
                    longest = (longest.length() >subString.length())? longest :subString ;
            }
        }
        return longest;
    }
}
