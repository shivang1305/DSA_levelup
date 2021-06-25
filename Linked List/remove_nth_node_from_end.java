/* Date: 25-June-2021 

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Input: head = [1,2,3,4,5], n = 2

Output: [1,2,3,5]
*/



public class remove_nth_node_from_end {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) // base case
            return head;
        
        ListNode fast = head, slow = head;
        
        if(head.next == null) // for the linked list of single node only
            head = null;
        
        else if(n == 1) {
            fast = fast.next;
            
            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            
            slow.next = null;
        }
        
        else {
            for(int i = 1; i < n; i++) {
                if(fast != null)
                    fast = fast.next;
            }
            
            while(fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.val = slow.next.val;
            slow.next = slow.next.next;
        }
        
        return head;
    }
}

// Time complexity = O(N)
// Space complexity = O(1)
