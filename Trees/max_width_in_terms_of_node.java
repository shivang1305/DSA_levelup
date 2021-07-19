/* LEETCODE - Medium                                                         Date: 19-July-2021
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
*/


import java.util.*;



public class max_width_in_terms_of_node {
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

    class Pair {
        TreeNode node;
        int idx;
        
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    
    // Here we are assuming the tree as binary heap (complete binary tree) which has all levels filled except the last level 
    // In complete BT we can represent its nodes in array as root idx = 0
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, 0));
        
        int maxWidth = 1;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.removeFirst();
                
                // left idx = (2 * idx) + 1
                if(p.node.left != null) 
                    que.addLast(new Pair(p.node.left, (2 * p.idx) + 1));
                
                // right idx = (2 * idx) + 2
                if(p.node.right != null) 
                    que.addLast(new Pair(p.node.right, (2 * p.idx) + 2));
            }
            
            // max width is the diff of leftmost and rightmost node of each level.
            if(que.size() > 0)
                maxWidth = Math.max(maxWidth, que.getLast().idx - que.getFirst().idx + 1);
        }
        
        return maxWidth;
        
        // Time complexity = O(N)
        // Space complexity = O(N)
    }
}
