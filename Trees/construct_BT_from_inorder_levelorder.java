/*
                                                                              Date: 19-Aug-2021

Given two integer arrays, inorder and levelorder where inorder is the inorder traversal of a binary tree of distinct values and levelorder is the levelorder traversal of the same tree, reconstruct and return the binary tree.

*/

import java.util.*;

public class construct_BT_from_inorder_levelorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode buildTree_(int[] inorder, int inSI, int inEI, int[] levelOrder) {
        if(inSI > inEI) // base case
          return null;
          
        TreeNode node = new TreeNode(levelOrder[0]);
        
        if(inSI == inEI) // when only single node is left in the array
          return node;
          
        int idx = inSI;
        while(inorder[idx] != levelOrder[0]) // search for the first element of levelorder[] in inorder[]
          idx++;
          
        HashSet<Integer> set = new HashSet<>();
        for(int i = inSI; i < idx; i++) // fill all the elements of inorder till idx (left subtree) in hashset for fast searching
          set.add(inorder[i]);
          
        // make seperate left and right arrays for level order
        int[] leftLevelOrder = new int[idx - inSI];
        int[] rightLevelOrder = new int[inEI - idx];
        
        int li = 0, ri = 0;
        
        // fill in both the created arrays
        for(int i = 1; i < levelOrder.length; i++) {
            int ele = levelOrder[i];
            if(set.size() != 0 && set.contains(ele)) { // if set contains the element
                leftLevelOrder[li++] = ele; // fill it in the left array
                set.remove(ele);
            }
            
            else 
                rightLevelOrder[ri++] = ele; // otherwise fill it in the right array
        }
        
        node.left = buildTree_(inorder, inSI, idx -1, leftLevelOrder);
        node.right = buildTree_(inorder, idx + 1, inEI, rightLevelOrder);
        
        return node;
    }
  
    public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
        int n = inorder.length;
        return buildTree_(inorder, 0, n - 1, levelOrder);
    }
      
    // Time complexity = O(N^2) -> since the searching and inserting the elements in left and right level order array will take up O(N) time
    // Space complexity = O(N + log N) -> log N for recursion and N for hashset and the left and right level order array
}
