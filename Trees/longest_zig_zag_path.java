/* LEETCODE - Medium                                                         Date: 15-July-2021
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 
Example 1:
    Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
    Output: 3
    Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Example 2:
    Input: root = [1,1,1,null,1,null,null,1,1,null,1]
    Output: 4
    Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
*/


public class longest_zig_zag_path {
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

    /* Approach 1 : Using pair class (for more clarity and readability of code) */
    
    class Pair {
        // -1 is the initial value because the length of zig-zag path is defined in terms of edges and not nodes
        int leftSlop = -1;  
        int rightSlop = -1;
        int maxLen = 0;
    }
    
    public int longestZigZag(TreeNode root) {
        Pair ans = longestZigZag_(root);
        return ans.maxLen;
    }
    
    public Pair longestZigZag_(TreeNode node) {
        if(node == null)
            return new Pair();
        
        Pair left = longestZigZag_(node.left);
        Pair right = longestZigZag_(node.right);
        
        Pair ans = new Pair();
        
        // obtain the maxLen uptill now
        ans.maxLen = Math.max(Math.max(left.rightSlop, right.leftSlop) + 1, Math.max(left.maxLen, right.maxLen));
        
        // obtain the leftSlop & rightSlop now
        ans.leftSlop = left.rightSlop + 1;
        ans.rightSlop = right.leftSlop + 1;
        
        return ans;
    }
    
    // Time complexity = O(N) -> (for N nodes in the tree)
    // Space complexity = O(1)
    
    /* Approach 2 : Using Array (for faster submission in test) */
    
    int maxLen = 0;
    
    public int longestZigZag2(TreeNode root) {
        longestZigZag_(root);
        return maxLen;
    }
    
    public int[] longestZigZag_2(TreeNode node) {
        if(node == null)
            return new int[]{-1, -1};
        
        int[] left = longestZigZag_2(node.left);
        int[] right = longestZigZag_2(node.right);
        
        maxLen = Math.max(maxLen, Math.max(left[1], right[0]) + 1);
        
        return new int[]{left[1] + 1, right[0] + 1};
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}
