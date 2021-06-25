/* Date: 25-June-2021 

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Input: head = [1,1,1,2,3]
Output: [2,3]
*/



public class remove_duplicate_from_sorted_list_2 {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) // base case for single node or zero length of LL
            return head;
        
        ListNode dummy = new ListNode(-1); // dummy node
        ListNode fast = head, slow = dummy;
        
        while(fast != null && fast.next != null) {
            
            if(fast.val != fast.next.val) { // when the values are diff
                if(slow == dummy)
                    slow.next = fast; // setting the link between slow and fast
                
                // updating both the pointers
                fast = fast.next;
                slow = slow.next;
            }
            
            else { // when we found duplicate value nodes
                ListNode ptr = fast.next; // assign a seperate node
                while(ptr != null && ptr.val == fast.val) // till we get a diff value
                    ptr = ptr.next; 
                
                // setting and breaking prev links
                fast = ptr;
                slow.next = fast;
            }
        }
        
        return dummy.next;
    }
}
