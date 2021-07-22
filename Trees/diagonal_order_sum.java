/*                                                                          Date: 22-July-2021
Given a Binary Tree, print Diagonal order sum of it.  
*/


import java.util.*;



public class diagonal_order_sum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /* Approach 1 - Using BFS method */

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(root);
        
        while(que.size() != 0) {
            int size = que.size();
            int sum = 0;
            
            while(size-- > 0) { // traverse one complete daigonal
                TreeNode node = que.removeFirst();
                
                while(node != null) {  // traverse a component
                    sum += node.val;
                    
                    if(node.left != null)
                        que.addLast(node.left);
                        
                    node = node.right;
                }
            }
            
            ans.add(sum);
        }
        
        return ans;


        // Time complexity = O(N)
        // Space complexity = O(N)
    }

    /* Approach 2 - Using DFS method */

    public static ArrayList<Integer> diagonalOrderSum2(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        return diagOrderSum(root, 0, ans);
    }
  
  public static ArrayList<Integer> diagOrderSum(TreeNode node, int level, ArrayList<Integer> arr) {
      if(node == null)
        return arr;
        
      if(arr.size()  == level)
        arr.add(0);
        
      arr.set(level, arr.get(level) + node.val);
        
      if(node.left != null)
        diagOrderSum(node.left, level + 1, arr);
        
      if(node.right != null)
        diagOrderSum(node.right, level, arr);
        
      return arr;

      // Time complexity = O(N)
      // Space complexity = O(N)
  }
}
