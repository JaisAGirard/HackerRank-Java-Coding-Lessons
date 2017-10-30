package arraysLeftRotation;

import java.util.Scanner;

/*Lesson: Given an array of n integers and a number, 'd', perform 'd' left rotations on the array. 
Then print the updated array as a single line of space-separated integers.

Source: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem*/

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int k) {
    	if (a.length == k || k  % a.length == 0){
    		return a;
    	}
    	else if (a.length > k){
    		int[] temp = new int[k];
    		System.arraycopy(a, 0, temp, 0, k);
    		System.arraycopy(a, k, a, 0, a.length - k);
    		System.arraycopy(temp, 0, a, a.length - k, k);
    		return a;
    	}
    	else{
    		int move = k % a.length;
    		int[] temp = new int[move];
    		System.arraycopy(a, 0, temp, 0, move);
    		System.arraycopy(a, move, a, 0, a.length - move);
    		System.arraycopy(temp, 0, a, a.length - move, move);
    		return a;    		
    	}
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
        in.close();
    }
}