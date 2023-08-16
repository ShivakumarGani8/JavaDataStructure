/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/

public class ValidPalindrome {
    public static void main(String[] args) {
        String example1="A man, a plan, a canal: Panama";
        String example2="race a car";
        String example3=" ";
        System.out.println(isValidPalindrome(example1)); //true
        System.out.println(isValidPalindrome(example2)); //false
        System.out.println(isValidPalindrome(example3)); //true
    }
    //In this code we will compare String from both the ends if somewhere the characters are miss matching will return false else true in the end 
    public static boolean isValidPalindrome(String input){
        String str=input.replaceAll("\\W", "").toLowerCase(); //For removing any spaces and special characters
        int forward=0; //For indexing from the first character
        int backward=str.length()-1; //For indexing from the last character
        while(forward<str.length()/2){
            if(str.charAt(forward++)!=str.charAt(backward--)) //If any characters miss match return flase
                return false;
        }
        return true;
    }
}
