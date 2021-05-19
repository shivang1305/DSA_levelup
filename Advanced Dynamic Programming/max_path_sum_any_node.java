class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class max_path_sum_any_node {
    int res = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    
    public int solve(TreeNode root) {
        if(root == null) // base condition 
            return 0;
        
        // HYPOTHESIS/FAITH
        int l = solve(root.left); // left ans
        int r = solve(root.right); // right ans
        
        //INDUCTION
        int temp = Math.max(0, Math.max(l, r)) + root.val; // in case of negative values of l & r we will take 0 i.e. sum will start from the curr node only excluding left and right sums as they are both negative.
        int ans = Math.max(temp, l + r + root.val); // when the curr node wants to become the ans 
        res = Math.max(res, ans); // final answer is res
        
        return temp; // but we return the temp ans to the upper node
    }
}
