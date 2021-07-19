/* LEETCODE - Medium                                                         Date: 18-July-2021
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
*/

import java.util.*;


public class right_view_of_BT {
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
                
                if(node.right != null)
                que2.add(node.right);
                if(node.left != null)
                    que2.add(node.left);
                
                flag = false;
            }
            
            else {
                if(node.right != null)
                que2.add(node.right);
                if(node.left != null)
                    que2.add(node.left);
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
                
                if(node.right != null)
                que.add(node.right);
                if(node.left != null)
                    que.add(node.left);
            }
        }
        
        return ans;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(N)
}

// The only diff b/w left and right view of BT is that here we make right call to child node first and then left call and in case of left view of BT we make left call first and then right.
