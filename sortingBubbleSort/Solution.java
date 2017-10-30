package sortingBubbleSort;

import java.util.*;

/*Lesson: Given an n-element array, A = a(0), a(1), ..., a(n-1), of distinct elements, 
sort array 'A' in ascending order using a provided Bubble Sort algorithm. 
Once sorted, print the following three lines:
1. "Array is sorted in 'numSwaps'.", where 'numSwaps' is the number of swaps that took place.
2. "First Element: 'firstElement'", where 'firstElement' is the first element in the sorted array.
3. "Last Element: 'lastElement'", where 'lastElement' is the last element in the sorted array.

Source: https://www.hackerrank.com/challenges/ctci-bubble-sort/problem*/

public class Solution {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int numberOfSwaps = 0;
    	int n = in.nextInt();
    	int[] a = new int[n];
    	for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();            
        }
    	
    	for (int i = 0; i < n; i++) {
    	    // Track number of elements swapped during a single array traversal    
    	    
    	    for (int j = 0; j < n - 1; j++) {
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	        	int temp = a[j];
    	        	a[j] = a[j+1];
    	        	a[j+1] = temp;
    	            numberOfSwaps++;
    	        }
    	    }
    	    
    	    // If no elements were swapped during a traversal, array is sorted
    	    if (numberOfSwaps == 0) {
    	        break;
    	    }
    	}
    	
    	System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
    	System.out.println("First Element: " + a[0]);
    	System.out.println("Last Element: " + a[a.length - 1]);
    	in.close();
    }
}