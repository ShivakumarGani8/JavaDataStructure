public class LongestPrefix {
    public static void main(String[] args) {
        String[] str1={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str1)); // fl: fl is common longest prefix 
        String[] str2={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(str2)); // "":  There is no common prefix among the input strings.

    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix="";
        int minLen=strs[0].length();
        String minString=strs[0];
        //Find String with minimum length
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<minLen){
                minString=strs[i];
                minLen=strs[i].length();
            }
        }
        //Check for prefix
        for(int i=0;i<minString.length();i++){
            char ch= minString.charAt(i);
            for(int j=0;j<strs.length;j++){
                //If prefix is not matching return prefix
                if(ch!= strs[j].charAt(i))
                return prefix;
            }
            prefix += ch;
        }
        return prefix;
    }
}
