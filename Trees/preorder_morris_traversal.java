/*                                                                           Date: 02-Aug-2021
Given a Binary Tree, return preorder Morris Traversal of it. 
*/



import java.util.*;



public class preorder_morris_traversal {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
          while(node.right != null && node.right != curr)
            node = node.right;
            
          return node;
      }
    
      public static ArrayList<Integer> morrisPreTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        TreeNode curr = node;
        while(curr != null) {
            TreeNode leftNode = curr.left;
            
            if(leftNode == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            
            else {
                leftNode = getRightMostNode(leftNode, curr); // obtain the rightmost node of left node
                
                if(leftNode.right == null) {
                    leftNode.right = curr; // create a thread
                    ans.add(curr.val); // adding the node value into the arraylist
                    curr = curr.left; // update the curr in left direction
                }
                
                else {
                    leftNode.right = null; // break the thread
                    curr = curr.right; // move curr towards right without storing the value in arraylist because this node is already processed
                }
            }
        }
        
        return ans;
      }    
}

// Time complexity = O(n)
// Space complexity = O(1) -> no recursion stack is used as there is no recursion in morris traversal
