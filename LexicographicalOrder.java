/*
Lexicographical Order, also known as alphabetic or dictionary order
Input: You are given with a string s and a integer k the length of the substring in the array.
Output: return min and max Lexicographical order in the substrings

Example:welcometojava
        3
OutPut: "ava" 
        "wel"
Explanation: String s has the following lexicographically-ordered substrings of s:
    "ava" is lexicographically small substring
    "wel" is lexicographically large substring
*/

class Lexicographical{
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        smallest= s.substring(0,k);
        largest= s.substring(0,k);
        for(int i=0;i<=s.length()-k;i++){
            if(0<=smallest.compareTo(s.substring(i,i+k))){
                smallest= s.substring(i,i+k);
            }
            if(0>=largest.compareTo(s.substring(i,i+k))){
                largest= s.substring(i,i+k);
            }
            
        }
        
        return smallest + "\n" + largest;
    }
}