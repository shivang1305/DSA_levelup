// Completely based on 2 prev questions (i.e. Burning Tree & All Nodes at Dist K)


import java.util.*;


public class burning_tree_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static int getTime(TreeNode node, int fireNode, int t) {
          if(node == null)
            return -1;
            
          if(node.val == fireNode) {
              kLevelsDown(node, 0, null);
              return 1;
          }
          
          int leftTime = getTime(node.left, fireNode, t);
          
          if(leftTime != -1) {
              kLevelsDown(node, t + leftTime, node.left);
              return leftTime + 1;
          }
          
          int rightTime = getTime(node.right, fireNode, t);
          
          if(rightTime != -1) {
              kLevelsDown(node, t + rightTime, node.right);
              return rightTime + 1;
          }
          
          return -1;
      }
      
      static int maxTime = 0;
      
      public static void kLevelsDown(TreeNode node, int t, TreeNode blocker) {
          if(node == null || node == blocker)
            return;
        
          if(ans.size() == 0) // first we will calculate the max time to burn the whole tree
            maxTime = Math.max(maxTime, t);
            
          else
            ans.get(t).add(node.val); // then we add the node to the list which has same time index
          
          kLevelsDown(node.left, t + 1, blocker);
          kLevelsDown(node.right, t + 1, blocker);
      }
      
      static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
      public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
        getTime(root, data, 0);
        for(int i = 0; i <= maxTime; i++) 
            ans.add(new ArrayList<>()); // so that we can decide how many entries are there in the ans arraylist as per max time to burn the whole tree
            
        getTime(root, data, 0);
        return ans;
      }
}
