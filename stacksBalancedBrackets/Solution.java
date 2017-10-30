package stacksBalancedBrackets;

import java.util.*;

/*Lesson: Given n strings of brackets, determine whether each sequence of brackets
is balanced.  If a string is balanced, print YES on a new line; otherwise,
print NO on a new line.

Source: https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem*/

public class Solution {
    
    public static boolean isBalanced(String expression) {
    	  Stack<Character> s = new Stack<>();
    	  char[] brackets = expression.toCharArray();
    	  for (char bracket : brackets) {
    	    if      (bracket == '{') s.push('}');
    	    else if (bracket == '[') s.push(']');
    	    else if (bracket == '(') s.push(')');
    	    else {
    	      if (s.empty() || bracket != s.peek())
    	        return false;
    	      s.pop();
    	    }
    	  }
    	  return s.empty();
    }  

  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
}
