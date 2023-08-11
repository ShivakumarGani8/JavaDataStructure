/*
A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.

Sample Input

{}()
({()})
{}(
[]
Sample Output

true
true
false
true
*/

import java.util.Scanner;
import java.util.Stack;
class BalancedString{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a string to check");
        String input=scan.next();
        if(isBalancedString(input))
        System.out.println("The given string is Balanced");
        else
        System.out.println("The given string is Not Balanced");
    }
    public static boolean isBalancedString(String input){
        if(input.length()%2!=0)
        return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<input.length();i++){
            char newChar=input.charAt(i);
            if(newChar=='(' || newChar=='[' || newChar=='{' ){ //Pushing the charachter to Stack if it is a opening bracket(it'll not cause in any problem if it is opening brakcet).
                stack.push(newChar);    
            }
            else{
                char lastChar=' ';
                if(stack.size()>=1)
                    lastChar= (char) stack.pop(); // Read & remove the lastly added character to stack(If there is a char exists in stack).
                switch(newChar){ // If the new character is closing bracket and not opened preor to close it then, return false(String is not balanced)
                    case ')': if(lastChar!='('){return false ;}
                    break;
                    case ']': if(lastChar!='['){return false ;}
                    break;
                    case '}': if(lastChar!='{'){return false ;}
                    break;
                }
            }
        }
        return true;
    }

}