/* Date: 28-June-2021 

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Input: head = [5], left = 1, right = 1
Output: [5]
*/

public class reverse_linked_list_in_a_range {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) // base case 
            return head;
        
        int count = 1; // we are counting indicies from 1 here
        
        ListNode prev = null, curr = head, forw = curr.next, p2 = null;
        ListNode p1 = new ListNode(-1); // dummy pointer
        
        while(curr != null && count < left + 1) {
            if(prev != null)
                p1 = prev;
            
            // updations
            prev = curr;
            curr = curr.next;
            forw = curr.next;
            
            count++;
        }
        
        p2 = prev; // setting link for starting of the range which is to be reversed
        
        while(curr != null && count <= right) { // reversal code
            forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
            count++;
        }
        
        // setting links for the reversed sub list to link with rest of the list
        p1.next = prev;
        p2.next = curr;
        
        return (left == 1) ? p1.next : head;
    }
    // Time complexity = O(N)
    // Space complexity = O(1)
}
