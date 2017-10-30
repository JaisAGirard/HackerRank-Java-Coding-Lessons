package stringsMakingAnagrams;

import java.util.*;

/*Lesson: Given two strings, 'a' and 'b', that may or may not be of the same length,
determine the minimum number of character deletions required to make 'a' and 'b'
anagrams.  Any characters can be deleted from either of the strings.

Source: https://www.hackerrank.com/challenges/ctci-making-anagrams/problem*/

public class Solution {
	
	public static int numberNeeded(String first, String second) {    	
    	ArrayList<Character> firstChar = new ArrayList<Character>();
    	ArrayList<Character> secondChar = new ArrayList<Character>();
    	int originalSize, counter;
    	boolean adjustCounter = true;
    	
    	for (char c: first.toCharArray()){  //Creates first character array
    		firstChar.add(c);
    	}
    	
    	for (char c: second.toCharArray()){  //Creates second character array
    		secondChar.add(c);
    	}
    	
    	originalSize = firstChar.size();  //Sets initial size for loop comparison before deletions as made in loop
    	counter = 0;  //Index adjustment for when no character match is found
    	for (int i = 0; i < originalSize; i++){  //Loops cycle through both arrays looking for matches
    		
    		A: for (int j = 0; j < secondChar.size(); j++){
    			if (firstChar.get(counter) == secondChar.get(j)){  //If match found, both elements are removed and loop A is broken
    				firstChar.remove(counter);					   
    				secondChar.remove(j);
    				adjustCounter = false;  //Adjustment for counter set to false to prevent index change in firstChar
    				break A;
    			}
    			else{  //If no match is found
    				adjustCounter = true;
    			}
    		}
    		
    		if (adjustCounter == true){  //If no match was found in loop A, adjustment will be true and will move to next index of firstChar
    			counter++;
    		}
    	}
    	
    	return firstChar.size() + secondChar.size();  //Returns number of remaining characters in both ArrayLists which are the necessary number of removals
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}