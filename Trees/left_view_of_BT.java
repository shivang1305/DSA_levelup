/* LEETCODE - Medium                                                         Date: 18-July-2021
1. Given a Binary Tree, print left view of it. 
2. Left view of a Binary Tree is set of nodes visible when tree is viewed from left side.

*/


import java.util.*;

public class left_view_of_BT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Intuition : Left view is basically the every first node at each level in level order traversal of tree.

    /* Approach 1 - Using 2 queues */

    public List<Integer> leftSideView(TreeNode root) {
        if(root == null) // edge case
            return new ArrayList<Integer>();
        
        Queue<TreeNode> que1 = new ArrayDeque<>(); // to store the parent nodes
        Queue<TreeNode> que2 = new ArrayDeque<>(); // to store the child nodes
        
        List<Integer> ans = new ArrayList<>();
        boolean flag = true; // to add the first node of every level into the ans arraylist
        
        que1.add(root);
        
        while(que1.size() > 0) {
            TreeNode node = que1.remove();
            
            if(flag == true) {
                ans.add(node.val);
                
                if(node.left != null)
                    que2.add(node.left);
                if(node.right != null)
                    que2.add(node.right);
                
                flag = false;
            }
            
            else {
                if(node.left != null)
                    que2.add(node.left);
                if(node.right != null)
                    que2.add(node.right);
            }
            
            if(que1.size() == 0) {
                que1 = que2;
                que2 = new ArrayDeque<>();
                flag = true;
            }
        }
        
        return ans;
    }

    // Time complexity = O(N)
    // Space complexity = O(2N) (for two queues)

    /* Approach 2 - Using single queue */

    public List<Integer> leftSideView2(TreeNode root) {
        if(root == null) // edge case
            return new ArrayList<Integer>();
        
        LinkedList<TreeNode> que = new LinkedList<>();
        
        List<Integer> ans = new ArrayList<>();
        
        que.addLast(root);
        
        while(que.size() > 0) {
            ans.add(que.getFirst().val);
            
            int size = que.size();
            
            while(size-- > 0) {
                TreeNode node = que.removeFirst();
                
                if(node.left != null)
                    que.add(node.left);
                if(node.right != null)
                    que.add(node.right);
            }
        }
        
        return ans;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(N)
}