public class lowest_common_ancestor {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      // to find that the given target node exists in the tree or not
      public static boolean find(TreeNode node, int tar) {
          if(node == null)
            return false;
            
          if(node.val == tar)
            return true;
            
          return find(node.left, tar) || find(node.right, tar);
      }
    
      public static TreeNode lowestCommonAncestor_(TreeNode node, int p, int q) {
        if(node == null) // base case
            return null;
            
        if(node.val == p || node.val == q) // when we found the common node (first node whose left and right subtree contains the value p and q)
            return node;
            
        // recursive left and right calls
        TreeNode left = lowestCommonAncestor_(node.left, p, q);
        TreeNode right = lowestCommonAncestor_(node.right, p, q);
        
        // every node will return null if it does not contain either of the node in any of its subtree or it will return the node (p or q which ever it contains)
        return (left != null && right != null) ? node : (left != null) ? left : right;
      }
      
      public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        
        if(find(root, p) == false || find(root, q) == false) // both p & q should exists in tree
            return null;
            
        return lowestCommonAncestor_(root, p, q);
      }

      // Time complexity = O(N)
      // Space complexity = O(log N) -> recursive stack space
}
