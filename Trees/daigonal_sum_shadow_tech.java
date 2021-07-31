/*                                                                          Date: 31-July-2021
Given a Binary Tree, print Diagonal order sum of it.  
*/



import java.util.*;



public class daigonal_sum_shadow_tech {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      // doubly linked list containing node
      public static class Node {
          int data;
          Node prev = null;
          Node next = null;
          
          Node(int data) {
              this.data = data;
          }
      }
      
      public static void dfs(TreeNode root, Node node) {
          node.data += root.val; // adding the curr node data into doubly ll node
          
          if(root.left != null) { // left call
              if(node.prev == null) {
                  Node newNode = new Node(0); // make a new doubly ll node 
                  node.prev = newNode; // attach it in the double ll
                  newNode.next = node;
              }
              
              dfs(root.left, node.prev); // doubly ll node will move to prev element
          }
          
          if(root.right != null) // right call
            dfs(root.right, node); // no change in doubly ll node
      }
    
      public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Node node = new Node(0);
        dfs(root, node);
        
        Node curr = node;
        
        while(curr != null) {
            ans.add(curr.data);
            curr = curr.prev;
        }
        
        return ans;
      }
}
