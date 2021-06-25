/* Date: 25-June-2021 

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/


public class remove_duplicate_from_sorted_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode curr = head;
        
        while(curr.next != null) {
            
            if(curr.val == curr.next.val)
                curr.next = curr.next.next;
            
            else
                curr = curr.next;
        }
        
        return head;
    }
}
