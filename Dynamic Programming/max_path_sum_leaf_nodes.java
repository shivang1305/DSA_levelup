public class max_path_sum_leaf_nodes {
    int res = Integer.MIN_VALUE;
    int maxPathSum(Node root)
    { 
        solve(root);
        return res;
    } 
    
    int solve(Node root) {
        if(root == null)
            return 0;
            
        int l = solve(root.left);
        int r = solve(root.right);
        
        int temp = Math.max(Math.max(l,r) + root.data, root.data);
        int ans =  Math.max(temp, l + r + root.data);
        res = Math.max(res, ans);
        
        return temp;
    }
}
