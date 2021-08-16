
public class flatten_binary_tree_to_linked_list {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
    }

    /* Approach 1 - Using simple reverse postorder traversal */
    
    TreeNode prev = null;
    
    public void flatten1(TreeNode root) {
        if(root == null)
            return;
        
        // Reverse postorder traversal 
        flatten1(root.right);
        flatten1(root.left);
        
        // attaching the links to flatten tree 
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(log n) -> for recursive stack
    
    /* Approach 2 - Using modified morris traversal */
    
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.left != null) {
                TreeNode leftNode = curr.left;
                
                while(leftNode.right != null)
                    leftNode = leftNode.right;
                
                leftNode.right = curr.right; // making a thread
                
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    
    // Time complexity = O(n)
    // Space complexity = O(1) -> since no recursion is used
}