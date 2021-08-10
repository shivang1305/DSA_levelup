
import java.util.*;

public class node_to_root_path {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
    }
      
    /* Approach 1 - Heap Over Method */
    
    public static boolean find(TreeNode node, int data, ArrayList<TreeNode> arr) {
        if(node == null) // base case 
        return false;
        
        if(node.val == data) {
            arr.add(node);
            return true;
        }
        
        boolean res = find(node.left, data, arr) || find(node.right, data, arr);
        
        if(res) 
        arr.add(node);
        
        return res;
        
        // Time complexity = O(N)
        // Space complexity = O(log N)
    }

    public static ArrayList<TreeNode> nodeToRootPath2(TreeNode node, int data) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        find(node, data, arr);
        return arr;
    }

    /* Approach - 2 Return Type Method */

    public static ArrayList<TreeNode> nodeToRootPath_(TreeNode node, int data) {
        if(node == null) // base case
            return null;

        if(node.val == data) {
            ArrayList<TreeNode> lis = new ArrayList<>();
            lis.add(node);
            return lis;
        }

        ArrayList<TreeNode> left = nodeToRootPath_(node.left, data);
        if(left != null) {
            left.add(node);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath_(node.right, data);
        if(right != null) {
            right.add(node);
            return right;
        }

        return null;
    }

    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        ArrayList<TreeNode> arr = nodeToRootPath_(node, data);
        return arr != null ? arr : new ArrayList<>();

        // Time complexity = O(N)
        // Space complexity = O(log N)
    }
    
}