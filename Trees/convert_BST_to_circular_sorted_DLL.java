
import java.util.*;



public class convert_BST_to_circular_sorted_DLL {
    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;
    
        Node(int val) {
          this.val = val;
        }
    }

    /* Approach 1 - Using simple inorder traversal & static variables are used */ 
      
    private static Node prev = null;
    
    private static void inorderTrav(Node node) {
        if(node == null) // base case
            return;
            
        inorderTrav(node.left);
        
        node.left = prev;
        prev.right = node;

        prev = prev.right;
        
        inorderTrav(node.right);
    }

    public static Node bToDLL(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;
        inorderTrav(root);

        Node head = dummy.right;

        // breaking links 
        dummy.right = null;
        head.left = null;

        // making the doubly LL circular
        head.left = prev;
        prev.right = head;

        return head;
    }

    // Time complexity = O(n) -> for inorder traversal
    // Space complexity = O(log n) -> for recursive stack

    /* Approach 2 - Using an iterative stack */

    private static void addAllLeftNodes(Node node, Stack<Node> st) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public static Node bToDLL2(Node root) {
        Stack<Node> st = new Stack<>();
        addAllLeftNodes(root, st);

        Node dummy = new Node(-1);
        Node prev = null;

        while(st.size() != 0) {
            Node curr = st.pop();

            curr.left = prev;
            prev.right = curr;
            prev = curr;

            addAllLeftNodes(curr.right, st);
        }
        Node head = dummy.right;

        // breaking links 
        dummy.right = null;
        head.left = null;

        // making the doubly LL circular
        head.left = prev;
        prev.right = head;

        return head;
    }

    // Time complexity = O(n)
    // Space complexity = O(log n) -> stack size at a time could be max of ht of tree i.e. log n


    /* Approach 3 - Using morris inorder traversal & no static variable is used */

    private static Node getRightMostNode(Node node, Node curr) {
        while(node.right != null && node.right != curr)
            node = node.right;

        return node;
    }

    private static Node inorderMorrisTraversal(Node root) {
        Node curr = root;
        Node dummy = new Node(-1);
        Node prev = dummy;

        while(curr != null) {
            Node leftNode = curr.left;

            if(leftNode == null) {
                curr.left = prev;
                prev.right = curr;
                prev = prev.right;

                curr = curr.right;
            }

            else {
                leftNode = getRightMostNode(leftNode, curr);

                if(leftNode.right == null) {
                    // create a thread
                    leftNode.right = curr;
                    curr = curr.left;
                }

                else {
                    // break the thread
                    leftNode.right = null;

                    curr.left = prev;
                    prev.right = curr;
                    prev = prev.right;

                    curr = curr.right;
                }
            }
        }
        
        Node head = dummy.right;

        // breaking links 
        dummy.right = null;
        head.left = null;

        // making the doubly LL circular
        head.left = prev;
        prev.right = head;

        return head;
    }

    public static Node bToDLL3(Node root) {
        return inorderMorrisTraversal(root);
    }

    // Time complexity = O(n)
    // Space complexity = O(1) -> since there is no recursion so no space of recursive stack
}
