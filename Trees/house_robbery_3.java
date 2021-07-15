/* LEETCODE - Medium                                                        Date: 15-July-2021
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.


Example 1:
    Input: root = [3,2,3,null,3,null,1]
    Output: 7
    Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
    Input: root = [3,4,5,1,3,null,1]
    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*/



public class house_robbery_3 {
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

    // At every node of the tree we have a chioce to do robbery or not with some contraints 

    class Pair {
        int robbery = 0;
        int noRobbery = 0;
    }
    
    public int rob(TreeNode root) {
        Pair p = maxRobbery(root);
        return Math.max(p.robbery, p.noRobbery);
    }
    
    public Pair maxRobbery(TreeNode node) {
        if(node == null)
            return new Pair();
        
        Pair left = maxRobbery(node.left);
        Pair right = maxRobbery(node.right);
        
        Pair p = new Pair();
        p.robbery = left.noRobbery + right.noRobbery + node.val; // if we do robbery at the curr node then we should not do robbery at any of its child nodes
        p.noRobbery = Math.max(left.robbery, left.noRobbery) + Math.max(right.robbery, right.noRobbery);
        
        return p;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}
