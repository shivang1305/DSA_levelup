import java.util.*;


public class construct_BST_from_levelorder {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Pair {
        TreeNode parent;
        int leftRange = -(int) 1e9;
        int rightRange = (int) 1e9;
        
        public Pair() {} // default constructor
        
        public Pair(TreeNode node, int lRange, int rRange) { // parameterized constructor
            parent = node;
            leftRange = lRange;
            rightRange = rRange;
        }
    }

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair());
        
        int idx = 0;
        TreeNode root = null;
        
        while(que.size() != 0 && idx < LevelOrder.length) {
            Pair rp = que.remove(); 
            
            int ele = LevelOrder[idx];
            
            if(ele < rp.leftRange || ele > rp.rightRange) // the element should belong to the range 
                continue;
                
            TreeNode node = new TreeNode(ele);
            idx++;
            
            if(rp.parent == null) // set the root node if not set
                root = node;
            
            else {
               if(ele < rp.parent.val) // for the node to be attached in the left of parent node
                    rp.parent.left = node;
                
                else // for the node to be attached in the right of parent node
                    rp.parent.right = node; 
            }
            
            que.add(new Pair(node, rp.leftRange, ele)); // add left range of curr node in the queue
            que.add(new Pair(node, ele, rp.rightRange)); // add right range of curr node in the queue
        }
        
        return root;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(2N)
}
