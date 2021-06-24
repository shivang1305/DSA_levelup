/* Date: 24-June-2021 

1. Merge two sorted linkedlists and return head of a sorted linkedlist. The list should be made by splicing together the nodes of the first two lists
2. Both list are sorted in increasing order.

Input Format
1->2->6->7->15->24->null
-1->0->6->17->25->null

Output Format
-1->0->1->2->6->6->7->15->17->24->25->null
*/


public class merge_sort_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midOfList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode mergeSortedLL(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return (l1 == null) ? l2 : l1;
            
        ListNode curr = new ListNode(0); // dummy node
        ListNode nHead = curr;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }

        if(l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
        
        return nHead.next;
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null) // base case for zero length or one length LL
            return head;
            
        ListNode mid = midOfList(head); // obtain the mid of the list
        ListNode nHead = mid.next; 
        mid.next = null; // break the link
        
        // recursive calls 
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(nHead);
        
        return mergeSortedLL(l1, l2); //merge both the lists
    }
}
