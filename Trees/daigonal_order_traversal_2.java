/*                                                                          Date: 20-July-2021
Given a Binary Tree, print Diagonal Order of it. 
(Anticlockwise direction)
*/



import java.util.*;



public class daigonal_order_traversal_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        
        que.addLast(root);
        
        while(que.size() != 0) {
            int size = que.size();
            ArrayList<Integer> diagonal = new ArrayList<>();
            
            while(size-- > 0) { // traverse one complete daigonal
                TreeNode node = que.removeFirst();
                
                while(node != null) {  // traverse a component
                    diagonal.add(node.val);
                    
                    if(node.right != null)
                        que.addLast(node.right);
                        
                    node = node.left;
                }
            }
            
            ans.add(diagonal);
        }
        
        return ans;

        // Time complexity = O(N)
        // Space complexity = O(N)
    }
}
