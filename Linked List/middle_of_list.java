/* Date: 23-June-2021 

Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the first middle node.

Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
*/

public class middle_of_list {
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
}
