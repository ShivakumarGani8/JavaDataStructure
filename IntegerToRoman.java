import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/integer-to-roman/
public class IntegerToRoman {
 
    public static void main(String[] args) {
        System.out.println(intToRoman(3)); // III: I=1
        System.out.println(intToRoman(58)); //LVIII: L=50 V=5 III=3
        System.out.println(intToRoman(1994)); //MCMXCIV: M=1000 CM=900 XC=90 IV=4
    }

    /** We'll devide this problem in 4 categories
     * 1) The digit/num exists in the map
     * 2) The digit/num is one value lesser than decimal
     * 3) The digit/num is 1/2 - decimal value lesser than decimal
     * 4) The digit/num is lesser/greater than 5X decimal place.
     */
    public static String intToRoman(int num) {
        String result = "";

        // Roman values for digits
        Map<Integer,Character> roman=new HashMap<>();
        roman.put(1,'I');
        roman.put(5,'V');
        roman.put(10,'X');
        roman.put(50,'L');
        roman.put(100,'C');
        roman.put(500,'D');
        roman.put(1000,'M');


        // Start of decimal values for the given number
        int decimal=1;
        while(num>0){
            int digit=num%10;
            int value=digit*decimal;

    // 1) The digit/num exists in the map
            if(roman.containsKey(value))
                result = roman.get(value)+result;

    // 2) The digit/num is one value lesser than decimal
            else if(value == decimal*10-decimal)
                result = Character.toString(roman.get(decimal))+roman.get(decimal*10)+result;
    // 3) The digit/num is 1/2 - decimal value lesser than decimal    
            else if(value== decimal*5-decimal)
                result = Character.toString(roman.get(decimal))+roman.get(decimal*5)+result;
    // 4) The digit/num is lesser than 5X decimal place.
            else{
                //For value less than 5X decimal place.
                if(value<decimal*5){
                    while(value>=decimal){
                        result = roman.get(decimal)+result;
                        value -= decimal;
                    }
                //For value greater than 5X decimal place.
                }else{
                    String temp="";
                    temp = Character.toString(roman.get(decimal*5));
                    while(value>decimal*5){
                        temp =temp + roman.get(decimal);
                        value -= decimal;
                    }
                    result=temp+result;
                }
            }

            decimal *=10; //Increase the decimal value by 10 each time we loop for the number.
            num /= 10; //Remove last digit from num.
        }
        return result;
    }
    
}
