import java.util.regex.Pattern;


public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("        -32222222224323"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("7766767"));
    }

    //This function will convert any string into an int if integer exists in the String
    // public static int myAtoi(String s) {
    //     int num=0;
    //     s=s.trim();
    //     String[] strings=s.split(" ");
    //     for(String str: strings){
    //         if(Pattern.matches("[-+]?[0-9]+", str)){
    //             num = Integer.parseInt(str);
    //             return num;
    //         }
    //     }
    //     return 0;
    // }

    //This function convers string into long if long exists as a first element except spaces
    public static long myAtoi(String s) {
        long num=0;
        s=s.trim();
        String[] strings=s.split("[ ]+");
        if(Pattern.matches("[-+]?[0-9]+", strings[0])){
            num = Long.parseLong(strings[0]);
            return num;
        }
        return 0;
    }
}
