/*                                                                           Date: 05-Aug-2021
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False
*/

import java.util.*;



public class bst_iterator {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
          this.val = val;
        }
      }

/* Approach 1 - Brute Force Approach (taking up a space of O(N)) */
class BSTIterator {
    
    ArrayList<Integer> arr;
    
    public void inOrderTraversal(TreeNode node) {
        if(node == null)
            return;
        
        inOrderTraversal(node.left);
        
        arr.add(node.val);
        
        inOrderTraversal(node.right);
    }

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        inOrderTraversal(root);
    }
    
    public int next() {
        int node = arr.get(0);
        arr.remove(0);
        return node;
    }
    
    public boolean hasNext() {
        if(arr.size() > 0)
            return true;
        return false;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(N) -> for creating the array list 
}

/* Approach - 2 Using Stack (taking up a space of O(log N)) */

class BSTIterator2 {
    Stack<TreeNode> st;
    
    public BSTIterator2(TreeNode root) {
        st = new Stack<>();
        addAllLeftNodes(root);
    }
    
    private void addAllLeftNodes(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
    
    public int next() {
        TreeNode topNode = st.pop();
        
        addAllLeftNodes(topNode.right);
        
        return topNode.val;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(log N) -> at most the elements is equal to height of tree
    // for a skewed tree in a worst case stack can fill N elements
}

/* Approach - 3 Optimal Solution using Morris Traversal (using const space) */

class BSTIterator3 {
    TreeNode curr = null;
    
    public BSTIterator3(TreeNode root) {
        this.curr = root;
    }
    
    private TreeNode getRightMostNode(TreeNode node) {
        while(node.right != null && node.right != this.curr) {
            node = node.right;
        }
        
        return node;
    }
    
    private TreeNode morrisTraversal() {
        TreeNode res = null;
        
        while(this.curr != null) {
            TreeNode leftNode = this.curr.left;
            
            if(leftNode == null) {
                res = this.curr;
                this.curr = this.curr.right;
                
                break;
            }
            
            else {
                TreeNode rmostNode = getRightMostNode(leftNode);
                
                if(rmostNode.right == null) {
                    rmostNode.right = this.curr; // create a thread
                    this.curr = this.curr.left;
                }
                
                else {
                    rmostNode.right = null; // break the thread
                    
                    res = this.curr;
                    this.curr = this.curr.right;
                    
                    break; // since res and curr both are updated
                }
            }
        }
        
        return res;
    }
    
    public int next() {
        TreeNode res = morrisTraversal();
        
        return res.val;
    }
    
    public boolean hasNext() {
        return curr != null;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}
}
