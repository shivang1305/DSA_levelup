/* Date: 23-June-2021 

Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln 
reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 

Input Format
1->2->3->4->5->6->7->null

Output Format
1->7->2->6->3->5->4->null
*/


public class fold_of_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midOfList(ListNode head) {
        if(head == null || head.next == null) // base case for zero length or 1 length linked list
            return head;
            
        ListNode fast = head, slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode revOfList(ListNode head) {
        if(head == null || head.next == null) // base case for zero length and 1 length linked list
            return head;
            
        ListNode prev = null, curr = head, forw = null;
        
        while(curr != null) {
            forw = curr.next; // link to next element in LL
            
            curr.next = prev; // breaking the link and setting the new link
            
            // updating the pointers
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

    public static void fold(ListNode head) {
        if(head == null || head.next == null) // base case for zero length and 1 length LL
            return;
            
        ListNode mid = midOfList(head); // O(N)
        ListNode nHead = mid.next; // setting the heading for new list which is to reversed
        mid.next = null; // breaking the link
        
        nHead = revOfList(nHead); // reversing the latter half of the LL (O(N/2))
        
        ListNode c1 = head, c2 = nHead, f1 = null, f2 = null;
        
        while(c2 != null) { // folding the LL (O(N/2))
            // backup
            f1 = c1.next;
            f2 = c2.next;
            
            // setting new links
            c1.next = c2;
            c2.next = f1;
            
            // updating the pointers
            c1 = f1;
            c2 = f2;
        }
    }
}

// Time complexity = O(N)
// Space complexity = O(1)