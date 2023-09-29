
/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. The test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Returns
boolean: If a and b are anagrams, return true. Otherwise, return false.
*/

public class Anagram {
    public static void main(String[] args) {
        String a1="anagram";
        String b1="margana";
        System.out.println(isAnagram(a1, b1)); //true
        String a2="anagramm";
        String b2="marganaa";
        System.out.println(isAnagram(a2, b2));
    }
    static boolean isAnagram(String a, String b) {
        if(a.length()!=b.length()) //If both string are inequal length
        return false;
        
        for(int i=0;i<a.length();i++){
            String ch= Character.toString(a.charAt(i)) ; 
            int freq1=0;
            int freq2=0;
            for(int j=0; j<b.length();j++){
                if(ch.equalsIgnoreCase(Character.toString(a.charAt(j)))){
                    freq1++;
                }
                if(ch.equalsIgnoreCase(Character.toString(b.charAt(j)))){
                   freq2++;
                }
            }
            if(freq1!= freq2)
            return false;
        }
        return true;
    }
}
