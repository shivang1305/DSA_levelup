/*                                                                          Date: 31-July-2021
Given a Binary Tree, return inorder Morris Traversal of it. 
*/


import java.util.*;



public class in_order_morris_traversal {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static TreeNode getRightMostNode(TreeNode leftNode, TreeNode curr) {
          while(leftNode.right != null && leftNode.right != curr) {
              leftNode = leftNode.right;
          }
          
          return leftNode;
      }
    
      public static ArrayList<Integer> morrisInTraversal(TreeNode node) {
          ArrayList<Integer> ans = new ArrayList<>();
          TreeNode curr = node;
          
          while(curr != null) {
              TreeNode leftNode = curr.left;
              
              if(leftNode == null) {
                  ans.add(curr.val);
                  curr = curr.right;
              }
              
              else {
                  leftNode  = getRightMostNode(leftNode, curr);
                  
                  if(leftNode.right == null) { // create a thread
                      leftNode.right = curr;
                      curr = curr.left;
                  }
                  
                  else { // break the already existing thread (i.e. it indicates that the left subtree of curr node is completely processed)
                      leftNode.right = null; 
                      ans.add(curr.val); 
                      curr = curr.right;
                  }
              }
          }
          
          return ans;
      }
}

// Time complexity = O(n)
// Space complexity = O(1) -> since no recusion is used in morris traversal, therefore no extra space is used in the form of recursion stack
