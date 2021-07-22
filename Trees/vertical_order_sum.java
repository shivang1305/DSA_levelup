/*                                                                           Date: 22-July-2021
Given a Binary Tree, print Vertical Order Sum of it. 
*/


import java.util.*;



public class vertical_order_sum {
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

    /* Approach 1 - Using BFS method (i.e. level order traversal) */

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
            
        width(root, 0);
        int wid = rightWidth - leftWidth + 1;
        
        for(int i = 0; i < wid; i++) 
            arr.add(0);
        
        
        LinkedList<Pair> que = new LinkedList<>();
        int x = Math.abs(leftWidth);
        que.addLast(new Pair(root, x));
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.removeFirst();
                    
                int sum = arr.get(p.width) + p.node.val; // adding the element coming in vertical order 
                arr.set(p.width, sum); // setting the current sum (uptill now) in the array
                
                if(p.node.left != null) 
                    que.addLast(new Pair(p.node.left, p.width - 1));
                    
                if(p.node.right != null) 
                    que.addLast(new Pair(p.node.right, p.width + 1));
            }
        }
        
        return arr;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(N)

    /* Approach - 2 Using DFS method (Recursion) */

    public static ArrayList<Integer> verticalOrderSum2(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
            
        width(root, 0);
        int wid = rightWidth - leftWidth + 1;
        
        for(int i = 0; i < wid; i++) 
            arr.add(0);
        
        
        arr = vertOrderSum(root, arr, Math.abs(leftWidth));
        
        return arr;
    }
    
    public static ArrayList<Integer> vertOrderSum(TreeNode node, ArrayList<Integer> arr, int width) {
        if(node == null)
            return arr;
        
        arr.set(width, arr.get(width) + node.val);
            
        if(node.left != null)
            vertOrderSum(node.left, arr, width - 1);
            
        if(node.right != null)
            vertOrderSum(node.right, arr, width + 1);
            
        return arr;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(N)
}
