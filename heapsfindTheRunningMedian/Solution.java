package heapsfindTheRunningMedian;

import java.util.*;

/*Lesson: Given an input stream of n integers, you must perform the following task for each integer:
1. Add the integer to a running list of integers.
2. Find the median of the updated list (i.e., for the first element through the most recent element).
3. Print the list's updated median on a new line.  The printed value must be a double-precision number
scaled to 1 decimal place (i.e., 12.3 format).

Source: https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem*/

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        LinkedList<Integer> medianSet = new LinkedList<Integer>();
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();            
        }
        
        float median;
        for (int c: a){
        	medianSet.add(c);
        	Collections.sort(medianSet);
        	if (medianSet.size() % 2 == 0){
        		median = (float)(medianSet.get(medianSet.size() / 2) + medianSet.get((medianSet.size() / 2) - 1)) / 2;
        	}
        	else{
        		median = (float) medianSet.get(((medianSet.size() + 1) / 2) - 1);
        	}
        	System.out.println(median);
        }
        in.close();
    }
}
