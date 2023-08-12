import java.util.Stack;

import javax.naming.spi.DirStateFactory.Result;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
*/

public class ReversePolishNotation {
    public static void main(String[] args) { 
        String[] example1={"2","1","+","3","*"};
        String[] example2={"4","13","5","/","+"};
        String[] example3={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evaluteReversePolishNotation(example1)); //9
        System.out.println(evaluteReversePolishNotation(example2)); //6
        System.out.println(evaluteReversePolishNotation(example3)); //22
    }

    public static int evaluteReversePolishNotation(String[] input){
        int result=0;
        Stack<Integer> store= new Stack<>();
        for(int i=0;i<input.length;i++){
            String data=input[i]; //Take elements from array

            if(data !="+" && data!="-" && data!="*" && data!="/" && data!="%"){
                store.push(Integer.parseInt(data)); //Push elements to stack if it is not a arithmetic operator
            }else{  //If arithmetic operator
                int previous= store.pop(); //Take lastly added element
                int old= store.pop(); //Take element added before last element

                switch(data){ //Evaluate the equation by based on the operator
                    case "+" : result=old+previous;
                    break;
                    case "-" : result=old-previous;
                    break;
                    case "*" : result=old*previous;
                    break;
                    case "/" : result=old/previous;
                    break;
                    case "%" : result=old%previous;
                    break;
                    default : System.out.println("An unknown error occured...!");
                }
                store.push(result); //Once result is calculated add result to the end of the stack for next evaluation
            }
        }
        return result;
    }
}
