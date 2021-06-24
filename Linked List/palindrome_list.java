/* Date: 23-June-2021 

Given a singly linked list of Integers, determine it is a palindrome or not.

Input Format
1->2->3->4->3->2->1->null
1->2->3->4->2->1->null

Output Format
true
false
*/


public class palindrome_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode midOfList(ListNode head) {
        if(head == null || head.next == null) // base case for length of LL= 0 or 1 
            return head;
            
        ListNode slow = head, fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public static ListNode revOfList(ListNode head) {
        if(head == null || head.next == null) // base case for length of LL = 0 or 1
            return head;
            
        ListNode prev = null, curr = head, forw = null;
        
        while(curr != null) {
            forw = curr.next; // backup of next element of LL for moving forward
            
            curr.next = prev; // setting the reverse link
            
            // update the pointers
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
            
        ListNode mid = midOfList(head); // obtaining the mid of the LL (O(N))
        ListNode nHead = mid.next; // assigning the head pointer to the latter half of list
        mid.next = null; // breaking the original list
        
        nHead = revOfList(nHead); // reversing the latter half of orignal LL
        
        ListNode c1 = head, c2 = nHead;
        
        while(c2 != null) {
            if(c1.val != c2.val)
                return false;
                
            c1 = c1.next;
            c2 = c2.next;
        }
    
        return true;
    }
}
// Time complexity = O(N)
// Space complexity = O(1)