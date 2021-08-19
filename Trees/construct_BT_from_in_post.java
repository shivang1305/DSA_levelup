/*
Leetcode - MEDIUM                                                           Date: 19-Aug-2021

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 
Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
*/



public class construct_BT_from_in_post {
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

    public TreeNode buildTree_(int[] inorder, int inSI, int inEI, int[] postorder, int postSI, int postEI) {
        if(postSI > postEI) // base case
            return null;
        
        TreeNode node = new TreeNode(postorder[postEI]);
        
        if(postSI == postEI) // when only single element is left in both arrays
            return node;
        
        int idx = inSI;
        while(inorder[idx] != postorder[postEI]) // find the last element of postorder[] in inorder[]
            idx++;
        
        int tnel = idx - inSI; // count the total number of elements till that index
        
        node.left = buildTree_(inorder, inSI, idx - 1, postorder, postSI, postSI + tnel - 1);
        node.right = buildTree_(inorder, idx + 1, inEI, postorder, postSI + tnel, postEI - 1);
        
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree_(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    // Time complexity = O(N^2) -> searching the element takes upto O(N) time
    // Space complexity = O(log N) -> recursive stack takes space upto the height of BT 
}
