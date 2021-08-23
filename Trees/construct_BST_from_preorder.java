public class construct_BST_from_preorder {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    } 
    
    int idx = 0;
    private TreeNode bstFromPreorder(int[] preorder, int leftRange, int rightRange) {
        // base case (when idx exeeceds the array length or does not belong to left or right range)
        if(idx >= preorder.length || preorder[idx] < leftRange || preorder[idx] > rightRange)
            return null;
        
        TreeNode node = new TreeNode(preorder[idx++]); // create the node with curr index
        
        // recursive left and right calls
        node.left = bstFromPreorder(preorder, leftRange, node.val);
        node.right = bstFromPreorder(preorder, node.val, rightRange);
        
        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        // default left and right range is -(infinity) to (infinity)
        int leftRange = -(int)1e9 - 1;
        int rightRange = (int)1e9 + 1;
        
        return bstFromPreorder(preorder, leftRange, rightRange);
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}
