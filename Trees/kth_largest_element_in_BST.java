public class kth_largest_element_in_BST {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /* Approach 1 - Using simple reverse inorder traversal */

    static int num = 0;
    static int ans = 0;

    public static void revInorder(TreeNode node, int k) {
        if(node == null)
            return;

        revInorder(node.right, k);

        num++;
        if(num == k) {
            ans = node.val;
            return;
        }

        revInorder(node.left, k);
    }

    public static int kthLargestInBST(TreeNode root, int k) {
        revInorder(root, k);
        return ans;
    }

    // Time complexity = O(N)
    // Space complexity = O(log N)

    /* Approach 2 - Using reverse morris inorder traversal */

    public static TreeNode getLeftMostNode(TreeNode node, TreeNode curr) {
        while(node.left != null && node.left != curr) 
            node = node.left;
        
        return node;
    }

    public static int revInorderMorris(TreeNode node, int k) {
        TreeNode curr = node;
        int num = 0;
        int ans = 0;

        while(curr != null) {
            TreeNode rightNode = curr.right;

            if(rightNode == null) {
                // inorder area
                num++;
                if(num == k) {
                    ans = curr.val;
                    break;
                }

                curr = curr.left;
            }

            else {
                rightNode = getLeftMostNode(rightNode, curr);

                if(rightNode.left == null) {
                    rightNode.left = curr; // create a reverse thread
                    curr = curr.right;
                }

                else {
                    rightNode.left = null; // break the reverse thread
                    // inorder area
                    num++;
                    if(num == k) {
                        ans = curr.val;
                        break;
                    }

                    curr = curr.left;
                }
            }
        }

        return ans;
    }

    public static int kthLargestInBST2(TreeNode root, int k) {
        return revInorderMorris(root, k);
    }

    // Time complexity = O(N)
    // Space complexity = O(1)
}