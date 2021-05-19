class Node {
    int data;
    Node left;
    Node right;
}

public class diameter_of_binary_tree 
{
    //Function to return the diameter of a Binary Tree.
    static int res = Integer.MIN_VALUE;
    int diameter(Node root) {
        solve(root);
        return res;
    }
    
    int solve(Node root) {
        // BASE CONDITION
        if(root == null)
            return 0;
            
        // HYPOTHESIS/FAITH
        int l = solve(root.left);
        int r = solve(root.right);
        
        //INDUCTION
        int temp = Math.max(l, r) + 1; // when the curr node wants to pass the dai upto itself to the upper node 
        int ans = 1 + l + r; // when the curr node wants to be the ans & keep the dai passing through itself only not root
        res = Math.max(res, ans);
        
        return temp;
    }
}