package queuesATaleOfTwoStacks;

import java.util.*;

/*Lesson: Implement a queue using two stacks.  Then process q queries, where each query is 
one of the following 3 types:
1. 'x': Enqueue element 'x' into the end of the queue.
2. Dequeue the element at the front of the queue.
3. Print the element at the front of the queue.

Source: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem*/

public class Solution {
	
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
    
    public static class MyQueue<T>{
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
             prepOld();
             return stackOldestOnTop.peek();
        }

        public T dequeue() {
            
            prepOld();
            return stackOldestOnTop.pop();
            
        }
        
        public void prepOld(){
            if (stackOldestOnTop.isEmpty())
                while(!stackNewestOnTop.isEmpty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
        }   	
    }
}