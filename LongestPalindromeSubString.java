/*
Given a String of length n. return the longest palindrome sub string in given string.
*/


public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String str = "a";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String str){
        String longest="";
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String subString=str.substring(i,j+1);
                int start=0;
                int end=subString.length()-1;
                while(start<end){
                    if(subString.charAt(start)==subString.charAt(end)){
                        start++;
                        end--;
                        continue;
                    }       
                    else
                        break; 
                }
                if(start==end || start>end)
                    longest = (longest.length() >subString.length())? longest :subString ;
            }
        }
        return longest;
    }
}
