/*                                                                          Date: 20-July-2021
Given a Binary Tree, print top View of it. 
*/

import java.util.*;



public class top_view {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    static class Pair {
        TreeNode node;
        int width;
        
        Pair(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }
    
    static int leftWidth = 0, rightWidth = 0;
    
    public static void width(TreeNode node, int width) {
        if(node == null)
            return;
            
        leftWidth = Math.min(leftWidth, width);
        rightWidth = Math.max(rightWidth, width);
        
        width(node.left, width - 1);
        width(node.right, width + 1);
        
        return;
    }

    /**
     * Top view of Binary Tree contains the nodes which occcurs first on vertical order traversal at each level
     */

    public static ArrayList<Integer> TopView(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
            
        width(root, 0);
        int wid = rightWidth - leftWidth + 1;
        
        for(int i = 0; i < wid; i++) 
            arr.add(null);
        
        LinkedList<Pair> que = new LinkedList<>();
        int x = Math.abs(leftWidth);
        que.addLast(new Pair(root, x));
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.removeFirst();
                
                if(arr.get(p.width) == null) // only put the first element at each level
                    arr.set(p.width, p.node.val);
                
                if(p.node.left != null) 
                    que.addLast(new Pair(p.node.left, p.width - 1));
                    
                if(p.node.right != null) 
                    que.addLast(new Pair(p.node.right, p.width + 1));
            }
        }
        
        return arr;
        
        // Time complexity = O(N.logN)
        // Space complexity = O(N)
    }
}
