public class construct_BST_from_postorder {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int idx = 0;
    
    private static TreeNode bstFromPostorder(int[] postorder, int leftRange, int rightRange) {
        // base case (when idx exeeceds the array length or does not belong to left or right range)
        if(idx < 0 || postorder[idx] < leftRange || postorder[idx] > rightRange)
            return null;
        
        TreeNode node = new TreeNode(postorder[idx--]); // create the node with curr index starting from last 
        
        // recursive right and left calls (in reverse order)
        node.right = bstFromPostorder(postorder, node.val, rightRange);
        node.left = bstFromPostorder(postorder, leftRange, node.val);
        
        return node;
    }
    
    public static TreeNode bstFromPostorder(int[] postorder) {
        idx = postorder.length - 1;
        // default left and right range is -(infinity) to (infinity)
        int leftRange = -(int)1e9 - 1;
        int rightRange = (int)1e9 + 1;
        
        return bstFromPostorder(postorder, leftRange, rightRange);
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}
