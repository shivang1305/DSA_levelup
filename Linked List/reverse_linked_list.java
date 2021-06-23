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
}

// Time complexity = O(N)
// Space complexity = O(1)
