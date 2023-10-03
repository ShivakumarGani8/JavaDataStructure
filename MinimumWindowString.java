import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t)); //BANC: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
    }

    // https://leetcode.com/problems/minimum-window-substring/
    public static String minWindow(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();//Map to store character's count in t.
        //Store characters and count in map.
        for(int i=0;i<t.length();i++){
            int count=0;
            char ch=t.charAt(i);
            for(int index=i;index<t.length();index++)
                if( ch== t.charAt(index)) count++;
            map.putIfAbsent(ch,count);
        }

        String window="";
        int windowSize=t.length(); //Initial size of window which changes every time once looping throught string is completed.
        //Loop max upto length of main String.
        while(windowSize<=s.length()){

            //To read substring from s.
            for(int j=0;j<=s.length()-windowSize;j++){
                window=s.substring(j,j+windowSize);
                Set<Character> keySet=map.keySet(); //Take characters from map traverse
                boolean contains=false;
                for(char ch : keySet){
                    int count=0;

                    for(int index=0;index<window.length();index++)
                        if( ch == window.charAt(index)){
                            count++;
                        }
                    //If total count of characters in map is greater or == characters in t then we can say it contains required character.
                    if(count >= map.get(ch)){
                        contains=true;
                    } else{ //If it is not contains specified number of characters we can set contains false and break current loop.
                        contains=false;
                        break;
                    }
                }
                //At the end if contains all the character's return window.
                if(contains) return window;
            }
            windowSize++;
        }
        return "";
    }
}
