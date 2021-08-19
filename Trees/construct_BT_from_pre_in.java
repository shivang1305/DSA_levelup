/*
Leetcode - MEDIUM                                                           Date: 19-Aug-2021

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
*/

public class construct_BT_from_pre_in {
    public class TreeNode {
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

    public TreeNode buildTree_(int[] preorder, int preSI, int preEI, int[] inorder, int inSI, int inEI) {
        if(preSI > preEI) // base case
            return null;
        
        TreeNode node = new TreeNode(preorder[preSI]);
        
        if(preSI == preEI) // for the last remaining node in both the arrays
            return node;
        
        int idx = inSI;
        while(inorder[idx] != preorder[preSI]) // searching the element in inorder[] O(N)
            idx++;
        
        int tnel = idx - inSI; // total number of elements till the searched index
        
        node.left = buildTree_(preorder, preSI + 1, preSI + tnel, inorder, inSI, idx); 
        node.right = buildTree_(preorder, preSI+ tnel + 1, preEI, inorder, idx + 1, inEI);
        
        return node;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree_(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    
    // Time complexity = O(N^2) -> since searching the element in inorder[] takes the extra time of O(N)
    // Space complexity = O(log N)
}
