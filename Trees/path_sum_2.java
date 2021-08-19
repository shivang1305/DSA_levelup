import java.util.*;

public class path_sum_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }
    
    public static void pathSumHelper(TreeNode root, int targetSum, int currSum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans) {
        if(root == null)
            return;
        
        // making the necassary changes before making a call (preorder changes)
        currSum += root.val;
        list.add(root.val);
        
        if(root.left == null && root.right == null && currSum == targetSum) { // if the node is leaf node & condition is satisfied
            ArrayList<Integer> temp = new ArrayList<>(list);
            ans.add(temp);
        }
            
        pathSumHelper(root.left, targetSum, currSum, list, ans);
        pathSumHelper(root.right, targetSum, currSum, list, ans);
        
        // while backtracking undo the operations performed in preorder 
        currSum -= root.val;
        list.remove(list.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        pathSumHelper(root, targetSum, 0, list, ans);
        
        return ans;
    }
}
