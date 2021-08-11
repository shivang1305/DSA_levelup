/*                                                                           Date: 10-Aug-2021
Given a Binary Tree, return list of all single child parent of binary tree
*/


import java.util.*;

public class all_single_child_parent {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static void singleChildParent(TreeNode node, ArrayList<Integer> ans) {
          if(node == null || (node.left == null && node.right == null))
            return;
            
          if(node.left == null || node.right == null)
            ans.add(node.val);
            
          singleChildParent(node.left, ans);
          singleChildParent(node.right, ans);
      }
    
      public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        singleChildParent(root, ans);
        return ans;
      }

      // Time complexity = O(n)
      // Space complexity = O(log n)
}