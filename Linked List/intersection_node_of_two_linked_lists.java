/* Date: 07-July-2021 

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


It is guaranteed that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3

Output: Intersected at '8'

Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
*/

public class intersection_node_of_two_linked_lists {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /* Approach 1 - Difference method */
    // Time Complexity = O(N)
    // Space Complexity = O(1)

    public int length(ListNode head) {
        if(head == null)
            return 0;
            
        ListNode curr = head;
        int count = 0;
        
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        
        return count;
    }
    
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);
        
        // obtain the diff b/w the length of both LL and find the intersection node 
        if(len1 > len2) {
            int diff = len1 - len2;
            
            while(diff-- > 0) 
                headA = headA.next;
        }
        
        else {
            int diff = len2 - len1;
            
            while(diff-- > 0)
                headB = headB.next;
        }
        
        while(headA != null && headB != null) {
            if(headA == headB)
                return headA;
            
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    /* Approach 2 - Floyd Cycle Detection Method */
    // Time Complexity = O(N)
    // Space Complexity = O(1)
    
    public ListNode getStartingNodeOfCycle(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                break;
        }
        
        if(slow != fast)
            return null;
        
        slow = head;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode curr = headA;
        
        while(curr.next != null)
            curr = curr.next;
        
        curr.next = headB; // creating a cycle in the given linked lists
        
        ListNode ans = getStartingNodeOfCycle(headA);
        
        curr.next = null;
        
        return ans;
    }
}