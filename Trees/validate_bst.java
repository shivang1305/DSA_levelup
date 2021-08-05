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

    /* Approach 2 - Using Morris Inorder Traversal */
    
    public TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while(node.right != null && node.right != curr)
            node = node.right;
        
        return node;
    }
    
    public boolean isValidBST2(TreeNode root) {
        TreeNode prev = null, curr = root;
        
        while(curr != null) {
            TreeNode leftNode = curr.left;
            
            if(leftNode == null) {
                if(prev != null && prev.val >= curr.val)
                    return false;
                
                prev = curr;
                curr = curr.right;
            }
            
            else {
                leftNode = getRightMostNode(leftNode, curr);
                
                if(leftNode.right == null) {
                    leftNode.right = curr;
                    curr = curr.left;
                }
                
                else {
                    if(prev.val >= curr.val)
                        return false;
                    
                    leftNode.right = null;
                    
                    prev = curr; // updating the prev node before updating the curr node
                    curr = curr.right;
                }
            }
        }
        
        return true;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(1) -> no recursion is done so no space of recursion stack is occupied
}