/*
Leetcode - MEDIUM                                                           Date: 19-Aug-2021

Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.


Example 1:

Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
*/


public class max_prod_of_splitted_BT {
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

    long prod = 0, totalSum = 0;
    
    private int sumOfTree(TreeNode node) {
        if(node == null)
            return 0;
    
        int sum = node.val + sumOfTree(node.left) + sumOfTree(node.right);
        prod = Math.max(prod, (totalSum - sum) * sum);
        
        return sum;
    }
    
    public int maxProduct(TreeNode root) {
        totalSum = sumOfTree(root); // first call to fill totalSum static variable
        sumOfTree(root); // second call to find product
        return (int)(prod % (int)(1e9 + 7));
    }
    
    // Time complexity = O(n)
    // Space complexity = O(log n)
}