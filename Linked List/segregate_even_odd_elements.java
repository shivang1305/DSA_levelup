/* Date: 25-June-2021 

Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

Input Format
    1->7->2->6->3->5->4->null

Output Format
    2->6->4->1->7->3->5->null
*/


public class segregate_even_odd_elements {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null) // base case for zero node or 1 node in LL
            return head;
        
        // dummy nodes for odd and even lists
        ListNode currEven = new ListNode(-1);
        ListNode currOdd = new ListNode(-1);
        
        ListNode headEven = currEven;
        ListNode headOdd = currOdd;
        
        ListNode curr = head;
        
        while(curr != null) {
            
            if(curr.val % 2 == 0) {
                currEven.next = curr;
                currEven = currEven.next;
            }
            
            else {
                currOdd.next = curr;
                currOdd = currOdd.next;
            }
            
            curr = curr.next;
        }
        
        currEven.next = headOdd.next; // joining the even and the odd list
        currOdd.next = null; // to avoid the cycle in LL **(most imp line - if not put we can get TLE)**
        
        return headEven.next;
    }
}
