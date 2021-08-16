public class max_path_sum_between_two_leafs {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /* Approach 1 - Using Pair class and simple recursion (postorder traversal) */
      
    public static class Pair {
        int LTLMaxSum = -(int) 1e9 - 1; // leaf to leaf max path sum
        int NTLMaxSum = -(int) 1e9 - 1; // node to leaf max path sum
    }

    public static Pair maxPathSum1_(TreeNode node) {
        Pair p = new Pair();
        
        if(node == null) // base case
        return p;
        
        if(node.left == null && node.right == null) { // in case of leaf node
            p.NTLMaxSum = node.val; // update the node to leaf max sum
            return p;
        }
        
        // recursive left and right calls
        Pair lp = maxPathSum1_(node.left);
        Pair rp = maxPathSum1_(node.right);
        
        // update the leaf to leaf max sum if it exists in left subtree or right subtree completely and does not pass through the curr node
        p.LTLMaxSum = Math.max(lp.LTLMaxSum, rp.LTLMaxSum);
        
        // for a non leaf node
        if(node.left != null && node.right != null) 
            p.LTLMaxSum = Math.max(p.LTLMaxSum, lp.NTLMaxSum + node.val + rp.NTLMaxSum); // update the leaf to leaf max sum if it passes through curr node
        
        p.NTLMaxSum = Math.max(lp.NTLMaxSum, rp.NTLMaxSum) + node.val;
        
        return p;
    }
      
    public static int maxPathSum1(TreeNode root) {
        return maxPathSum1_(root).LTLMaxSum;
    }
      
      // Time complexity = O(n)
      // Space complexity = O(log n)

      /* Approach 2 - Heap Over Method (using static variables) */

    static int LTLMaxSum = -(int) 1e9 - 1; // this will store max of leaf to leaf max path sum of left & right subtree

    public static int maxPathSum2_(TreeNode node) {
        if(node == null)
            return -(int) 1e9 - 1;
            
        if(node.left == null && node.right == null) // in case of a leaf node 
            return node.val; // return the node to leaf max sum as the value of node itself
            
        // getting node to leaf max sum from left and right subtree
        int NTLLeft = maxPathSum2_(node.left); 
        int NTLRight = maxPathSum2_(node.right);
        
        if(node.left != null && node.right != null) // for a non leaf node
            LTLMaxSum = Math.max(LTLMaxSum, NTLLeft + node.val + NTLRight); // max of curr LTL max sum & max path sum passing from curr node in left and right subtree 
        
        return Math.max(NTLLeft, NTLRight) + node.val; // returning curr Node to leaf max path sum
    }
  
    public static int maxPathSum2(TreeNode root) {
        maxPathSum2_(root);
        return LTLMaxSum;
    }

    // Time complexity = O(n)
    // Space complexity = O(logn)

    
    
    /* Approach - 3 Heap Over Method (without using static variable)*/

    // pass array instead of making a static variable
    // array -> is present on heap
    // other variables are present on the recursion stack that's why it value changes with each recursive call

    public static int maxPathSum3_(TreeNode node, int[] LTLMaxPathSum) {
        if(node == null)
            return -(int) 1e9 - 1;
            
        if(node.left == null && node.right == null) // in case of a leaf node 
            return node.val; // return the node to leaf max sum as the value of node itself
            
        // getting node to leaf max sum from left and right subtree
        int NTLLeft = maxPathSum3_(node.left, LTLMaxPathSum); 
        int NTLRight = maxPathSum3_(node.right, LTLMaxPathSum);
        
        if(node.left != null && node.right != null) // for a non leaf node
            LTLMaxPathSum[0] = Math.max(LTLMaxPathSum[0], NTLLeft + node.val + NTLRight); // max of curr LTL max sum & max path sum passing from curr node in left and right subtree 
        
        return Math.max(NTLLeft, NTLRight) + node.val; // returning curr Node to leaf max path sum
    }
  
    public static int maxPathSum3(TreeNode root) {
        int[] LTLMaxPathSum = new int[1];
        LTLMaxPathSum[0] = -(int) 1e9 - 1;

        maxPathSum3_(root, LTLMaxPathSum);
        return LTLMaxSum;
    }

    // Time complexity = O(n)
    // Space complexity = O(logn)
}
