/* Date: 09-July-2021 

1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
2. pivot is always be last index of linkedlist.
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.

Input Format
    1->5->2->9->5->14->11->1->10->10->1->3->null

Output Format
    3->5->9->5->14->11->10->10->null 
*/

public class segregate_on_last_node {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode curr = head;
        
        while(curr.next != null) 
            curr = curr.next;
        
        int val = curr.val; // value of node at last index which is our target node
            
        // dummy pointers
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        
        ListNode c1 = smaller, c2 = larger;
        
        curr = head;
        
        while(curr != null) {
            if(curr.val <= val) {
                c1.next = curr;
                c1 = curr;
            }
            
            else {
                c2.next = curr;
                c2 = curr;
            }
            
            curr = curr.next;
        }
        
        c1.next = null;
        c2.next = null;
        
        c1.next = larger.next;
        
        return c1;
    }

    // Time Complexity = O(N)
    // Space Complexity = O(1)
}