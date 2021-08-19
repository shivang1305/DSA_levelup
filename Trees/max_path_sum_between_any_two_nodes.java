public class max_path_sum_between_any_two_nodes {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
    }
      
    public static class Pair {
        int NTNMaxSum = -(int) 1e9; // node to node max path sum (i.e. this is what our final ans is)
        int RTNMaxSum = 0; // root to node max path sum (to get max sum passing from curr node or root node)
    }
      
    // special type of java function in which we pass a dynamic array which is used when we don't know how many parameters are there at runtime or there are many params and we want to perform some common operations on all the params 
    public static int getMax(int... arr) { 
        int max = arr[0];
        
        for(int ele : arr)
        max = Math.max(max, ele);
        
        return max;
    }
    
    public static Pair maxPathSum_(TreeNode node) {
        Pair p = new Pair();
        
        if(node == null)
        return p;
        
        Pair lp = maxPathSum_(node.left);
        Pair rp = maxPathSum_(node.right);
        
        // obtaining all possible conditions and taking out max path from all possible scenarios
        
        p.RTNMaxSum = Math.max(Math.max(lp.RTNMaxSum, rp.RTNMaxSum) + node.val, node.val);
        
        p.NTNMaxSum = getMax(p.RTNMaxSum, lp.NTNMaxSum, rp.NTNMaxSum, lp.RTNMaxSum + node.val + rp.RTNMaxSum);
        
        return p;
    }

    public static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
            
        return maxPathSum_(root).NTNMaxSum;
    }
    
    // Time complexity = O(n)
    // Space complexity = O(log n)
}
