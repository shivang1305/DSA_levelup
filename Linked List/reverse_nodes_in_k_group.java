/* Date: 26-June-2021 

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
*/


public class reverse_nodes_in_k_group {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode tempHead = null;
    static ListNode tempTail = null;
    
    public static void addFirst(ListNode node) {
        if(tempHead == null) {
            tempHead = node;
            tempTail = node;
        }
        
        else {
            node.next = tempHead;
            tempHead = node;
        }
    }
    
    public static int length(ListNode node) {
        ListNode curr = node;
        int len = 0;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        return len;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) // base case
            return head;
        
        ListNode overallHead = null, overallTail = null; // final list ptrs
        ListNode curr = head;
        
        int len = length(head);
        
        while(len >= k) { // till the length of the list is more than k
            int tempK = k;
            
            while(tempK-- > 0) { // this loop will run k times
               ListNode forw = curr.next; // backup
               curr.next = null; // breaking the link
               
               addFirst(curr); // add this node in first of temp list
               curr = forw; // updation of curr ptr
            }
            
            // adding temp list in overall list accordingly
            if(overallHead == null) 
                overallHead = tempHead;
            
            else 
                overallTail.next = tempHead;
            
            overallTail = tempTail;
            
            // setting temp list to null again
            tempHead = null;
            tempTail = null;
            
            // decreasing the length of given list by k
            len -= k;
        }
        
        overallTail.next = curr; // for the left out nodes if any which are not grouped in k length groups
        
        return overallHead;
    }

    // Time complexity = O(N)
    // Space complexity = O(1)
}
