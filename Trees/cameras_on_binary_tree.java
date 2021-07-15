/* LEETCODE - Hard                                                           Date: 15-July-2021
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

 
Example 1:
    Input: root = [0,0,null,0,0]
    Output: 1
    Explanation: One camera is enough to monitor all nodes if placed as shown.

Example 2:
    Input: root = [0,0,null,0,null,0,null,null,0]
    Output: 2
    Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
*/

public class cameras_on_binary_tree {
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

    static int cameraCount = 0;
    
    public static int minCameraCover(TreeNode root) {
        int ans = cameraCountHelper(root);
        return ans == -1 ? cameraCount+ 1 : cameraCount;
    }
    
    public static int cameraCountHelper(TreeNode node) {
        if(node == null) // base case
            return 1;
        
        int leftChild = cameraCountHelper(node.left); 
        int rightChild = cameraCountHelper(node.right); 
         
        // Postorder call
        if(leftChild == -1 || rightChild == -1) {
            cameraCount++;
            return 0;
        }
        
        if(leftChild == 0 || rightChild == 0)
            return 1;
        
        return -1;
    }
    
    // Time complexity = O(N)  (for N nodes in the tree there will be N recursive calls)
    // Space complexity = O(1)
}