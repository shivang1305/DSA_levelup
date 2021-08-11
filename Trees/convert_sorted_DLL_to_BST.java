/*                                                                           Date: 10-Aug-2021
1. Convert a sorted Doubly-Linked List to a Balanced Binary Search Tree in place.
2. The previous and next pointers in nodes are to be used as left and right pointers respectively in converted Binary Search Tree. 
3. The tree must be constructed in-place (No new node should be allocated for tree conversion) 
*/


public class convert_sorted_DLL_to_BST {
    public static class Node {
        int val = 0;
        Node left = null;
        Node right = null;
    
        Node(int val) {
          this.val = val;
        }
      }
      
      public static Node middle(Node head) {
          if(head == null || head.right == null)
            return head;
            
          Node slow = head, fast = head;
          
          while(fast.right != null && fast.right.right != null) {
              fast = fast.right.right;
              slow = slow.right;
          }
          
          return slow;
      }
    
      // left : prev, right : next
      public static Node SortedDLLToBST_(Node head) {
        if(head == null || head.right == null)
            return head;
    
        Node mid = middle(head); // get the middle node of DLL
        
        // next and prev node of mid node 
        Node newHead = mid.right; 
        Node prev = mid.left;
        
        // break all the links
        newHead.left = null;
        mid.left = null;
        mid.right = null;
        if(prev != null) // prev can be null in case of 2 nodes left in DLL
            prev.right = null;
        
        // recursive left and right calls
        mid.left = SortedDLLToBST_(prev != null ? head : null);
        mid.right = SortedDLLToBST_(newHead);
        
        return mid;
      }
      
      public static Node SortedDLLToBST(Node head) {
        return SortedDLLToBST_(head);
      }

      // Time complexity = O(n)
      // Space complexity = O(log n) -> for recursive stack
}
