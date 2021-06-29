/* Date: 29-June-2021 

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

*/



public class cycle_node_of_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) // base case
            return null;
        
        ListNode slow = head, fast = head; // 2 pointer approach
        
        while(fast != null && fast.next != null) {
            // updations
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow) // cycle is detected
                break;
        }
        
        if(slow != fast) // if cycle is not detected
            return null;
        
        slow = head; // place slow ptr again to head
        
        while(slow != fast) { // now move both ptrs with equal speeds till both meet
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow; // now the meeting pt is the starting node of cycle in LL
    }
}
