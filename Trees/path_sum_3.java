public class path_sum_3 {
    class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
		    this.val = val;
		    this.left = null;
		    this.right = null;
	    }
    }
    
    int countPaths = 0;
    
    // function to calculate the path sum starting from root
    private void calcSum(TreeNode node, int targetSum, int sum) {
        if(node == null)
            return;
        
        sum += node.val;
        
        if(sum == targetSum)
            countPaths += 1;
            
        calcSum(node.left, targetSum, sum);
        calcSum(node.right, targetSum, sum);
    }
    
    private void preorderTraversal(TreeNode node, int targetSum) {
        if(node == null)
            return;
        
        calcSum(node, targetSum, 0);
        
        preorderTraversal(node.left, targetSum);
        preorderTraversal(node.right, targetSum);
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        preorderTraversal(root, targetSum);
        
        return countPaths;
        
    }
    
    // Time complexity = O(n^2) -> same nodes are visited multiple times by calSum() and traversal()
    // Space complexity = O(1) -> if we don't consider recursive stack space
}