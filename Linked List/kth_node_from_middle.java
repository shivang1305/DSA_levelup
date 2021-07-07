/* Date: 06-July-2021 

Given a linked list A of length N and an integer B.

You need to find the value of the Bth node from the middle towards the beginning of the Linked List A.

If no such element exists, then return -1.

NOTE:

Position of middle node is: (N/2)+1, where N is the total number of nodes in the list.

Input 1:
 A = 3 -> 4 -> 7 -> 5 -> 6 -> 1 6 -> 15 -> 61 -> 16
 B = 3
Output 1:
 4

Input 2:
 A = 1 -> 14 -> 6 -> 16 -> 4 -> 10
 B = 2

Output 2:
 14
*/

public class kth_node_from_middle {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int solve(ListNode head, int B) {
        ListNode slow = head;
        ListNode fast = head;
        int mid = 0;
        
        //This loop will make point slow to the middle element and 'mid' will contain the mid length of the given linked list
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            mid++;
            fast = fast.next.next;
        }
        
        //Returning -1 in case the desired position is greater than B (Caution:In case you initialize mid with 1, you need to check for B>=mid)
        if(B > mid) 
            return -1;
        
        //Finding the actual kth value from the beginning of list
        int kthFromHead = mid - B;
        slow = head;
        
        //Moving to the kth node from beginning
        while(kthFromHead-- > 0) 
            slow = slow.next;
        
        return slow.val;
    }
}