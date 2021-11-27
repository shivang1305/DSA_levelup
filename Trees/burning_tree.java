// Totally based on the prev question (i.e. All nodes at k dist from the given node in BT)
// Specially Important Question for Amazon

public class burning_tree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
      
      public static int getTime(TreeNode node, int fireNode) {
          if(node == null)
            return -1;
            
          if(node.val == fireNode) {
              kLevelsDown(node, 0, null);
              return 1;
          }
          
          int leftTime = getTime(node.left, fireNode);
          
          if(leftTime != -1) {
              kLevelsDown(node, leftTime, node.left);
              return leftTime + 1;
          }
          
          int rightTime = getTime(node.right, fireNode);
          
          if(rightTime != -1) {
              kLevelsDown(node, rightTime, node.right);
              return rightTime + 1;
          }
          
          return -1;
      }
      
      static int maxTime = 0;
      
      public static void kLevelsDown(TreeNode node, int t, TreeNode blocker) {
          if(node == null || node == blocker)
            return;
            
          maxTime = Math.max(maxTime, t);
          
          kLevelsDown(node.left, t + 1, blocker);
          kLevelsDown(node.right, t + 1, blocker);
      }
    
      public static int burningTree(TreeNode root, int fireNode) {
          getTime(root, fireNode);
          return maxTime;
      }
    
      // Time complexity = O(N)
      // Space complexity = O(1) -> if we exclude recursive stack space 
}
