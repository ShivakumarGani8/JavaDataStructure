import java.util.HashMap;
import java.util.Map;

//leetcode.com/problems/integer-to-roman/
class RomanToInteger{
    public static void main(String[] args) {
        System.out.println("III"); //3 I=1
        System.out.println("LVIII"); //58: L = 50, V= 5, III = 3.
        System.out.println("MCMXCIV"); //58: M = 1000, CM = 900, XC = 90 and IV = 4.
    }

    //In this problem we'll consider a situation where if, next char value is greater than current we have to substract the current by next. else, add the current value to the result.

    public static int romanToInt(String s) {
        int result=0;
        Map<Character,Integer> roman=new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);
        roman.put('N',0);
        int index=0;
        while(index < (s.length())){
            int value1=0, value2=0;
            char ch1='N',ch2='N';
            ch1= s.charAt(index);
            value1= roman.get(ch1);

            //We have to select both the values until there is a next char in the string
            if(index < s.length()-1){
                ch2=s.charAt(index+1);
                value2= roman.get(ch2);
            }

            //If current is greater than next add current
            if(value1>=value2)
                result += value1;
            //else substract current value by next and add it to result
            else{
                result += value2-value1;
                index++;
            }
            index++;
        }
        return result;
    }
}