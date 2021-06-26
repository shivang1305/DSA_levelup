/* Date: 23-June-2021 

Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]

Output: [5,4,3,2,1]
*/

public class reverse_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode revOfList(ListNode head) {
        if(head == null || head.next == null) // base case for length of LL = 0 or 1
            return head;
            
        ListNode prev = null, curr = head, forw = null;
        
        while(curr != null) {
            forw = curr.next; // backup of next element of LL for moving forward
            
            curr.next = prev; // setting the reverse link
            
            // update the pointers
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
    // Time complexity = O(N)
    // Space complexity = O(1)  

    /* Approach 2 - using add first method */

    static ListNode tempHead = null;
    
    public static void addFirst(ListNode node) {
        if(tempHead == null)
            tempHead = node;
        else {
            node.next = tempHead;
            tempHead = node;
        }
    }

    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) // base case for length of LL = 0 or 1
            return head;
            
        ListNode curr = head, forw = head;
        
        while(curr != null) {
            forw = curr.next; // backup
            curr.next = null;
            
            addFirst(curr);
            
            curr = forw;
        }
        
        return tempHead;
    }
    // Time complexity = O(N)
    // Space complexity = O(1)
}
