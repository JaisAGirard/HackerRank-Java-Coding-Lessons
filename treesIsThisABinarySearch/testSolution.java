package treesIsThisABinarySearch;

/*Lesson: For the purposes of this challenge, we define a binary search tree to be a binary tree
with the following ordering properties:
-The 'data' value of every node in a node's left subtree is less than the data value of that node.
-The 'data' value of every node in a node's right subtree is greater than the data value of that node.

Given the root node of a binary tree, determine if it's also a binary search tree.

Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree.
It must return a boolean denoting whether or not the binary tree is a binary search tree. 
You may have to write one or more helper functions to complete this challenge.

Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.

You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree 
and pass its root node to your function as an argument.  You are not responsible for printing any output 
to stdout. Your function must return true if the tree is a binary search tree; otherwise, it must return false. 
Hidden code stubs will print this result as a Yes or No answer on a new line.

Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
     
Source: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem*/

public class testSolution {

    boolean checkBST(Node root) {
        boolean check;
        
        if (root == null){
            return false;
        }
        else if (root.left == null && root.right == null){
            return true;
        }
        else{
            check = drillLeft(root.left, root.data);
            if (!check == false){
            	check = drillRight(root.right, root.data);
            }
        }
        
        return check;
    }

    boolean drillLeft(Node rootLeft, int rootDataLeft){
        boolean checkLeft;
        
        if (rootLeft == null){
            return true;
        }
        else if (rootLeft.data < rootDataLeft){
        	checkLeft = drillLeft(rootLeft.left, rootLeft.data);
        	if (!checkLeft == false){
        		checkLeft = drillRight(rootLeft.right, rootLeft.data);
        	}
        	return checkLeft;
        }
        else return false;
    }
    
    boolean drillRight(Node rootRight, int rootDataRight){
        boolean checkRight;
        
        if (rootRight == null){
            return true;
        }
        else if (rootRight.data > rootDataRight){
        	checkRight = drillLeft(rootRight.left, rootRight.data);
        	if (!checkRight == false){
        		checkRight = drillRight(rootRight.right, rootRight.data);
        	}
        	return checkRight;
        }
        else return false;
    }    
}
