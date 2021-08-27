public class diameter_of_BT {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    } 

    /* Approach 1 - Using the height fuction */

    // -1 because height is calculated in terms of edges
    private int height(TreeNode node) {
        return (node == null) ? -1 : Math.max(height(node.left), height(node.right)) + 1;
    }
    
    private int diameter(TreeNode node) {
        if(node == null)
            return 0;
        
        // calculating left and right diameter from curr node of BT
        int leftDia = diameter(node.left);
        int rightDia = diameter(node.right);
        
        // if the diameter passes through the curr root node then 
        int dia = height(node.left) + height(node.right) + 2;
        
        // max daimeter is returned
        return Math.max(dia, Math.max(leftDia, rightDia));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
    }
    
    // Time complexity = O(n^2) -> every node is being visited multiple times
    // Time complexity = O(log n) -> for recursive stack

    /* Approach 2 - Without using a seperated height function */

    private class Pair {
        int diameter = 0;
        int height = -1;
    }
    
    private Pair calcDiameter(TreeNode node) {
        Pair p = new Pair();
        
        if(node == null) // base case
            return p;
        
        // obtain left and right pairs
        Pair lp = calcDiameter(node.left);
        Pair rp = calcDiameter(node.right);
        
        // calc the diameter and height for the curr node
        p.diameter = Math.max(Math.max(lp.diameter, rp.diameter), lp.height + rp.height + 2);
        p.height = Math.max(lp.height, rp.height) + 1;
        
        return p;
    }
    
    public int diameterOfBinaryTree2(TreeNode root) {
        Pair ans = calcDiameter(root);
        return ans.diameter;
    }
    
    // Time complexity = O(n) -> since every node of BT is visited only once
    // Space Complexity = O(log n) -> for recursive stack

    /* Approach 3 - Using array instead of class */

    private int[] calcDiameter2(TreeNode node) {
        if(node == null)
            return new int[]{0, -1}; // array representing daimeter and height

        int[] lAns = calcDiameter2(node.left);
        int[] rAns = calcDiameter2(node.right);

        int[] ans = new int[2];
        ans[0] = Math.max((Math.max(lAns[0], rAns[0])), lAns[1] + rAns[1] + 2);
        ans[1] = Math.max(lAns[1], rAns[1]) + 1;

        return ans;
    }

    public int diameterOfBinaryTree3(TreeNode root) {
        int[] ans = calcDiameter2(root);
        return ans[0];
    }

    // Time complexity = O(n) -> since every node of BT is visited only once
    // Space Complexity = O(log n) -> for recursive stack

    /* Approach 4 - Using static variable for daimeter and returning only height from func */

    int daimeter = 0;

    private int calcDiameter3(TreeNode node) {
        if(node == null)
            return -1;

        int leftHt = calcDiameter3(node.left);
        int rightHt = calcDiameter3(node.right);

        daimeter = Math.max(daimeter, leftHt + rightHt + 2);

        return Math.max(leftHt, rightHt) + 1;
    }

    public int diameterOfBinaryTree4(TreeNode root) {
        calcDiameter3(root);
        return daimeter;
    }

    // Time complexity = O(n) -> since we are only returning ht so all nodes are visited only once
    // Space complexity = O(log n) -> for recursive stack
}
