public class recover_bst {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
    }

    /* Approach 1 - Using simple recursive inorder traversal of BST & some static variables */
    
    TreeNode prev = null;
    TreeNode node1 = null, node2 = null;
    
    public void recoverTree_(TreeNode node) {
        if(node == null)
            return;
        
        recoverTree_(node.left);
        
        if(prev != null && prev.val > node.val) {
            if(node1 == null)
                node1 = prev;
            node2 = node;
        }
        
        prev = node;
        
        recoverTree_(node.right);
    }
    
    public void recoverTree1(TreeNode root) {
        // swap the value of node 1 & node 2
        recoverTree_(root);
        
        if(node1 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        } 
    }
    
    // Time complexity = O(n)
    // Space complexity = O(log n)
    
    /* Approach 2 - Using inorder morris traversal */
    
    private TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while(node.right != null && node.right != curr) 
            node = node.right;
        
        return node;
    }
    
    public void recoverTree2(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null, node1 = null, node2 = null;
        
        while(curr != null) {
            TreeNode leftNode = curr.left;
            
            if(leftNode == null) {
                if(prev != null && prev.val > curr.val) {
                    if(node1 == null)
                        node1 = prev;
                    node2 = curr;
                }
                
                prev = curr;
                curr = curr.right;
            }
            
            else {
                leftNode = getRightMostNode(leftNode, curr);
            
                if(leftNode.right == null) {
                    leftNode.right = curr; // create the thread
                    curr = curr.left;
                }

                else {
                    leftNode.right = null; // break the thread

                    if(prev != null && prev.val > curr.val) {
                        if(node1 == null)
                            node1 = prev;
                        node2 = curr;
                    }

                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        
        if(node1 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
    
    // Time complexity = O(n)
    // Space complexity = O(1)
}
