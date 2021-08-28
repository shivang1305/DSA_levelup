import java.util.*;


public class boundary_order_traversal {
    class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }
    }

    /* Approach 1 - Using multiple iterative preorder traversals seperately for left boundary, right boundary and leaves */
    
    public static boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
    
    public static void addLeftBoundary(TreeNode node, ArrayList<Integer> res) {
        TreeNode curr = node.left;
        
        while(curr != null) {
            if(isLeaf(curr) == false)
                res.add(curr.data);
            
        	if(curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }
    
    public static void addLeaves(TreeNode node, ArrayList<Integer> res) {
        if(node == null)
            return;
        
        if(isLeaf(node)) {
            res.add(node.data);
            return;
        }
        
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }
    
    public static void addRightBoundary(TreeNode node, ArrayList<Integer> res) {
        TreeNode curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(curr != null) {
            if(isLeaf(curr) == false)
                temp.add(curr.data);
            
        	if(curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
        
        for(int i = temp.size() - 1; i >= 0; i--) // reversing the elements of right boundary since we are moving in anticlock wise direction
            res.add(temp.get(i));
    }
    
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
        if(isLeaf(root) == false)
            ans.add(root.data);
        
        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        
        return ans;
	}
    
    // Time complexity = O(N)
    // Space complexity = O(N) -> for arraylist
}
