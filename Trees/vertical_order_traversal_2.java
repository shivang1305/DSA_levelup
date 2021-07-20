/* LEETCODE - Medium                                                         Date: 20-July-2021
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    Explanation:
    Column -1: Only node 9 is in this column.
    Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
    Column 1: Only node 20 is in this column.
    Column 2: Only node 7 is in this column.

Example 2:
    Input: root = [1,2,3,4,5,6,7]
    Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation:
    Column -2: Only node 4 is in this column.
    Column -1: Only node 2 is in this column.
    Column 0: Nodes 1, 5, and 6 are in this column.
            1 is at the top, so it comes first.
            5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
    Column 1: Only node 3 is in this column.
    Column 2: Only node 7 is in this column.
*/




import java.util.*;



public class vertical_order_traversal_2 {
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
    
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        
        if(root == null)
            return arr;
            
        width(root, 0);
        int wid = rightWidth - leftWidth + 1;
        
        for(int i = 0; i < wid; i++) 
            arr.add(new ArrayList<>());
        
        // here min priority queue is used because we want the elements of same width and vertical order in sorted form
        // Two queues are used so that the parent and child nodes are seperated at each level to avoid mixing of them as we are applying sorted on one horizontal level at a time
        
        PriorityQueue<Pair> parentQ = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });
        PriorityQueue<Pair> childQ = new PriorityQueue<>((a, b) -> {
            return a.node.val - b.node.val;
        });
        
        int x = Math.abs(leftWidth);
        parentQ.add(new Pair(root, x));
        
        while(parentQ.size() > 0) {
            int size = parentQ.size();
            
            while(size-- > 0) {
                Pair p = parentQ.remove();
                    
                arr.get(p.width).add(p.node.val);
                
                if(p.node.left != null) 
                    childQ.add(new Pair(p.node.left, p.width - 1));
                    
                if(p.node.right != null) 
                    childQ.add(new Pair(p.node.right, p.width + 1));
            }
            
            PriorityQueue<Pair> temp = parentQ;
            parentQ = childQ;
            childQ = temp;
        }
        
        return arr;
    }
    
    // Time complexity = O(N.logN)
    // Space complexity = O(N) 
}
