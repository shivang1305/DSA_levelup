public class construct_BST_from_inorder {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    } 
    
    public static TreeNode constructFromInOrder_(int[] inOrder, int si, int ei) {
        if(si > ei) // base case
            return null;
            
        int mid = (si + ei) >> 1; // obtaining the mid element
        TreeNode node = new TreeNode(inOrder[mid]); // makin the mid element of inorder[] as root(curr node)
        
        if(si == ei) // when only one element is left in inorder[]
            return node;
            
        // left and right recursive calls changing the starting and ending indices of array
        node.left = constructFromInOrder_(inOrder, si, mid - 1);
        node.right = constructFromInOrder_(inOrder, mid + 1, ei);
        
        return node;
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        int n = inOrder.length;
        return constructFromInOrder_(inOrder, 0, n - 1);
    }

    // Time complexity = O(n)
    // Space complexity = O(log n)
}
