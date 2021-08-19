public class path_sum_1 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
    }
    
      public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) // base case
                return false;
            
            if(root.left == null && root.right == null && root.val == targetSum) // for every leaf node
                return true; // check that node value is equal to modified target sum or not
            
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
