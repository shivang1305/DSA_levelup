/* LEETCODE - Medium                                                         Date: 18-July-2021
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:
    Input: root = [2,1,3]
    Output: true

Example 2:
    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.
*/


public class validate_bst {

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

    /* Intuition: The inorder traversal of BST is alaways sorted */
    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        
        return ans;
    }
    
    TreeNode prev = null;
    boolean ans = true;
    
    public void inOrderTraversal(TreeNode node) {
        if(node == null)
            return;
        
        inOrderTraversal(node.left);
        
        if(prev == null)
            prev = node;
        
        else if(node.val > prev.val)
            prev = node;
        
        else {
            ans = false;
            return;
        }
        
        inOrderTraversal(node.right);
        
        return;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1) 
}