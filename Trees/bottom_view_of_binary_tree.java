import java.util.*;


public class bottom_view_of_binary_tree {
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
        
        Pair() {}
        
        Pair(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }
    
    // obtain the width of the tree
    public static void widthOfTree(TreeNode node, int width, int[] minMaxWidth) {
        if(node == null)
            return;
            
        minMaxWidth[0] = Math.min(minMaxWidth[0], width);
        minMaxWidth[1] = Math.max(minMaxWidth[1], width);
        
        widthOfTree(node.left, width - 1, minMaxWidth);
        widthOfTree(node.right, width + 1, minMaxWidth);
    }

    public static ArrayList<Integer> BottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) // base case
            return ans;
        
        // min width -> left width i.e. 0 initially
        // max width -> right width i.e. 0 initially
        int[] minMaxWidth = new int[2]; 
        
        widthOfTree(root, 0, minMaxWidth); 
        
        int wid = minMaxWidth[1] - minMaxWidth[0] + 1;
        for(int i = 0; i < wid; i++)
            ans.add(0);
            
        Queue<Pair> que = new ArrayDeque<>();
        int x = Math.abs(minMaxWidth[0]);
        
        que.add(new Pair(root, x));
        
        while(que.size() != 0) {
            int size = que.size();
            
            while(size-- > 0) {
                Pair p = que.remove();
                
                ans.set(p.width, p.node.val);
                
                if(p.node.left != null) // add the left child
                    que.add(new Pair(p.node.left, p.width - 1)); // on left call width will decrease by 1
                    
                if(p.node.right != null) // add the right child
                    que.add(new Pair(p.node.right, p.width + 1)); // on right call width will increase by 1
            }
        }
        
        return ans;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(log N)
}
