package org.bst.operations; 

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== Testing Binary Tree Traversal ===");
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        TreeOperations treeOps = new TreeOperations();
        List<Integer> inorderResult = treeOps.iterativeInorder(root);
        
        System.out.println("Iterative Inorder Traversal Output: " + inorderResult);
        System.out.println();

        System.out.println("=== Testing Array Search Operations ===");
        
        int[] unsortedArray = {9, 3, 1, 7, 5, 8};
        ArrayOperations arrayOps = new ArrayOperations();

        int searchElement1 = 5;
        int searchElement2 = 20;
        
        System.out.println("--- Linear Search ---");
        System.out.println("Is " + searchElement1 + " in array? " + 
                           arrayOps.findUsingLinearSearch(unsortedArray, searchElement1)); 
        System.out.println("Is " + searchElement2 + " in array? " + 
                           arrayOps.findUsingLinearSearch(unsortedArray, searchElement2)); 

        int searchElement3 = 7;
        int searchElement4 = 0;
        
        System.out.println("\n--- Binary Search ---");
        System.out.println("Is " + searchElement3 + " in array? " + 
                           arrayOps.findUsingBinarySearch(unsortedArray, searchElement3)); 
        System.out.println("Is " + searchElement4 + " in array? " + 
                           arrayOps.findUsingBinarySearch(unsortedArray, searchElement4)); 
    }
}