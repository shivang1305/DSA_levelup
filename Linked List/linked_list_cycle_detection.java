/* Date: 29-June-2021 

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

*/

public class linked_list_cycle_detection {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /* Floyd Cycle Detection Algorithm or Rabbit and Tortiose Approach */
    
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) // base case
            return false;
        
        ListNode slow = head, fast = head; // 2 pointer approach
        
        while(fast != null && fast.next != null) {
            // updations
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) // cycle is detected
                return true;
        }
        
        return false; // cycle is not detected
    }
}