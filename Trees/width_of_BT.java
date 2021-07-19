/* LEETCODE - Medium                                                         Date: 19-July-2021
1. Given a Binary Tree, return Width Of Shadow Of A Binary Tree. 
*/


public class width_of_BT {
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

    public int widthOfBinaryTree(TreeNode root) {
        traversal(root, 0);
        return rightWidth - leftWidth + 1;
    }
    
    int leftWidth = 0, rightWidth = 0;
    
    public void traversal(TreeNode node, int width) {
        if(node == null)
            return;
        
        leftWidth = Math.min(leftWidth, width);
        rightWidth = Math.max(rightWidth, width);
        
        traversal(node.left, width - 1);
        traversal(node.right, width + 1);
        
        return;
    }
}
