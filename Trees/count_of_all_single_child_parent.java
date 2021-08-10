/*                                                                           Date: 10-Aug-2021
Given a Binary Tree, return count all single child parent of binary tree
*/


public class count_of_all_single_child_parent {

    /* Approach 1 - Using Global Variable (Heap over method)*/
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      static int count = 0;
      
      public static void singleChildParent(TreeNode node) {
          if(node == null || (node.left == null && node.right == null))
            return;
            
          if(node.left == null || node.right == null)
            count++;
            
          singleChildParent(node.left);
          singleChildParent(node.right);
      }
    
      public static int countExactlyOneChild(TreeNode root) {
          singleChildParent(root);
          return count;
      }

      /* Approach 2 - Without using Global Variable (Return type method) */

      public static int countSingleChildParent(TreeNode node) {
          if(node == null || (node.left == null && node.right == null)) // leaf node (base case)
            return 0;

          int left = countSingleChildParent(node.left);
          int right = countSingleChildParent(node.right);

          int ans = left + right;

          if(node.left == null || node.right == null)
            ans++;

          return ans;
      }

      public static int countExactlyOneChild2(TreeNode root) {
        return countSingleChildParent(root);
    }

    // for both the methods
    // Time complexity = O(n)
    // Space complexity = O(1)
}
