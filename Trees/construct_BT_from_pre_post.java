/*
Leetcode - MEDIUM                                                           Date: 19-Aug-2021

Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.

If there exist multiple answers, you can return any of them.


Example 1:

Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]
*/


public class construct_BT_from_pre_post {
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

    // preorder -> element at startIdx of array is always curr root 
    // preoreder -> go to next element of startIdx of array (say ele)
    // postorder -> find ele in postorder  (i.e. idx)
    // get the length of start idx of postorder to idx of ele (i.e. tnel)
    // break the preorder array from startIdx + 1 to startIdx + tnel & startIdx + tnel + 1 to endIdx
    // break the postorder array from startIdx to idx & idx + 1 to endIdx
    
    
    public TreeNode constructFromPrePost_(int[] preorder, int preSI, int preEI, int[] postorder, int postSI, int postEI) {

        if(preSI > preEI) // base condition
            return null;
        
        TreeNode node = new TreeNode(preorder[preSI]);
        
        if(preSI == preEI) // for last left node in the given pre & postorder
            return node;
        
        int idx = postSI;
        while(postorder[idx] != preorder[preSI + 1]) // O(N)
            idx++;
        
        int tnel = idx - postSI + 1;
        
        node.left = constructFromPrePost_(preorder, preSI + 1, preSI + tnel, postorder, postSI, idx);
        node.right = constructFromPrePost_(preorder, preSI + tnel + 1, preEI, postorder, idx + 1, postEI - 1);
        
        return node;
    }
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePost_(preorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    // Time complexity = O(N^2)
    // Space complexity = O(log N);
}
