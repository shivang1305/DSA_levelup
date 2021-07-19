/* LEETCODE - Medium                                                         Date: 19-July-2021
1. Given a Binary Tree, print Vertical Order of it. 

Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1

Sample Output
0 -> 1 1 
1 -> 1 1 1 
2 -> 1 1 
*/



import java.util.*;


public class vertical_order_traversal {
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

    static class Pair {
        TreeNode node;
        int width;
        
        Pair(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }

    /* Approach 1 - Using HashMap */
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        LinkedList<Pair> que = new LinkedList<>();
        que.addLast(new Pair(root, 0));
        
        int leftWidth = 0, rightWidth = 0;
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.removeFirst();
                map.putIfAbsent(p.width, new ArrayList<>());
                
                map.get(p.width).add(p.node.val); // pushing the elements at current level into hashmap
                
                // decreasing the width on adding left child
                if(p.node.left != null) {
                    que.addLast(new Pair(p.node.left, p.width - 1));
                    leftWidth = Math.min(leftWidth, p.width - 1);
                }
                
                // increasing the width on adding right child
                if(p.node.right != null) {
                    que.addLast(new Pair(p.node.right, p.width + 1));
                    rightWidth = Math.max(rightWidth, p.width + 1); 
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = leftWidth; i <= rightWidth; i++) // adding the elements from leftmost to rightmost level
            ans.add(map.get(i));
        
        return ans;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(2N) -> for hashmap & queue

    /* Approach 2 - Using ArrayList of ArrayList instead of HashMap */

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

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
            
        width(root, 0);
        int wid = rightWidth - leftWidth + 1;
        
        for(int i = 0; i < wid; i++) 
            arr.add(new ArrayList<>());
        
        
        LinkedList<Pair> que = new LinkedList<>();
        int x = Math.abs(leftWidth);
        que.addLast(new Pair(root, x));
        
        while(que.size() > 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.removeFirst();
                    
                arr.get(p.width).add(p.node.val);
                
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
}
