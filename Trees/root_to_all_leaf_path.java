/*                                                                           Date: 10-Aug-2021
Given a Binary Tree, return Root to all leaf path of binary tree
*/

import java.util.*;



public class root_to_all_leaf_path {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static void rootToAllLeafPath_(TreeNode node, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
          if(node == null) 
              return;
          
          list.add(node.val);
          
          rootToAllLeafPath_(node.left, list, ans);
          rootToAllLeafPath_(node.right, list, ans);
          
          if(node.left == null && node.right == null) {
              ArrayList<Integer> temp = new ArrayList<>(list);
              ans.add(temp);
          }
          
          list.remove(list.size() - 1);
      }
    
      public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
          ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
          ArrayList<Integer> list = new ArrayList<>();
          
          rootToAllLeafPath_(root, list, ans);
          
          return ans;

          // Time complexity = O(n)
          // Space complexity = O(log n)
      }
}
