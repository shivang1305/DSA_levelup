import java.util.*;


public class all_nodes_k_dist_away {
    class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
		    this.val = val;
		    this.left = null;
		    this.right = null;
	    }
    }

    /* Approach 1 - using extra space of O(n) for storing node to root path*/

    ArrayList<TreeNode> path = new ArrayList<>();
    
    private boolean find(TreeNode node, TreeNode target) {
        if(node == null)
            return false;
        
        if(node == target) {
            path.add(node);
            return true;
        }
        
        boolean leftAns = find(node.left, target);
        if(leftAns == true) {
            path.add(node);
            return true;
        }
        
        boolean rightAns = find(node.right, target);
        if(rightAns == true) {
            path.add(node);
            return true;
        }
        
        return false;
    }
    
    // O(n) in worst case
    private void kLevelsDown(TreeNode node, int k, TreeNode blocker, List<Integer> ans) { 
        if(node == null || k < 0 || node == blocker) // will not go in the direction of blocker
            return;
        
        if(k == 0) // when we reach k units down in the tree
            ans.add(node.val);
        
        kLevelsDown(node.left, k - 1, blocker, ans);
        kLevelsDown(node.right, k - 1, blocker, ans);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        find(root, target);
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < path.size(); i++) // path size can be O(n) in worst case
            kLevelsDown(path.get(i), k - i, (i == 0) ? null : path.get(i - 1), ans);
        
        // O(n) inside O(n) = O(n^2)
        
        return ans;
    }
    
    // Time complexity = O(n^2) -> every node of the tree is visited twice in worst case
    // Space complexity = O(n) -> path arraylist without including recursive space

    /*-------------------------------------------------------------------------------------*/

    /* Approach 2 - Without using any extra space to except for recursive space */

    // here in this approach we took an extra space of O(n) to store the root to node path which can be avoid by tweeking the logic a bit for root to node path function
    
    // Instead of storing the path we will call kDown() while backtracking after we found our target node
    
    // -1 -> target node is not found yet
    // 1 -> target node is found
    
    // As soon as we found the target node we must start backtracking decrease the value of k by 1 at each level while calling kDown()

    // it returns the dist from the target node to curr node
    private int getDist(TreeNode node, TreeNode target, int k, List<Integer> ans) {
        if(node == null) // this function will return -1 untill the target node is not found
            return -1;
        
        if(node == target) { // when the target node is found it will return 1
            kLevelsDown2(node, k, null, ans);
            return 1; 
        }
        
        int leftDist = getDist(node.left, target, k, ans);
        if(leftDist != -1) { // if the target node is found in the left subtree
            kLevelsDown2(node, k - leftDist, node.left, ans);
            return leftDist + 1;  // while backtracking increasing the dist each time by 1
        }
        
        int rightDist = getDist(node.right, target, k, ans);
        if(rightDist != -1) { // if the target node is found in the right subtree
            kLevelsDown2(node, k - rightDist, node.right, ans);
            return rightDist + 1; // while backtracking increasing the dist each time by 1
        }
        
        return -1;
    }
    
    private void kLevelsDown2(TreeNode node, int k, TreeNode blocker, List<Integer> ans) { // O(n) in worst case
        if(node == null || k < 0 || node == blocker) // will not go in the direction of blocker
            return;
        
        if(k == 0) // when we reach k units down in the tree
            ans.add(node.val);
        
        kLevelsDown(node.left, k - 1, blocker, ans);
        kLevelsDown(node.right, k - 1, blocker, ans);
    }
    
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        getDist(root, target, k, ans);
        
        return ans;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1) -> if recursive stack space is not counted
}
