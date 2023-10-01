import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubString{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3: The longest substring is abc
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1: The longest substring is b
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3: The longest substring is wke
    }


    public static int lengthOfLongestSubstring(String s) {
        int max=0;
        
        // for(int i=0;i<s.length();i++){
        //     int count=0;
        //     String subString=Character.toString(s.charAt(i));
        //     if(max>s.length()-i) return max;
        //     for(int j=i+1;j<s.length();j++){
        //         String ch= Character.toString(s.charAt(j));;
        //         if(!subString.contains(ch)){
        //             subString += ch;
        //             max=Math.max(max, subString.length());
        //         }else break;
        //     }
        // }

        // Create an empty set to add characters
        Set<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.clear();
            if(max>s.length()-i) return max;
            for(int j=i;j<s.length();j++){
                set.add(s.charAt(j));
                if(set.size()==(j-i+1)){ //If char is allowed to add inside set size of set == current length & continue with next char
                    continue;
                }else break; //If char is not allowed break
            }
            max=Math.max(max, set.size()); //Store max length
        }
        return max;
    }
}