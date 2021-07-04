/* Date: 03-July-2021 

Given a linked list A , reverse the order of all nodes at even positions.

Input 1:
 A = 1 -> 2 -> 3 -> 4

Input 2:
 A = 1 -> 2 -> 3


Output 1:
 1 -> 4 -> 3 -> 2

 Output 2:
 1 -> 2 -> 3

Explanation 1: Nodes are positions 2 and 4 have been swapped.

Explanation 2: No swapping neccassary here.
*/


public class even_reverse_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static int length(ListNode head) {
        if(head == null)
            return 0;
            
        int len = 0;
        ListNode curr = head;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        return len;
    }
    
    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode curr = head, prev = null;
        
        while(curr != null) {
            ListNode forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
    
    public ListNode solve(ListNode head) {
        if(length(head) <= 3)
            return head;
            
        ListNode odd = head, even = head.next;
        ListNode c1 = odd, c2 = even;
        
        while((c1 != null && c1.next != null) || (c2 != null && c2.next != null)) {
            
            if(c1 != null && c1.next != null) {
                c1.next = c1.next.next;
                c1 = c1.next;   
            }
           
            if(c2 != null && c2.next != null) {
                c2.next = c2.next.next;
                c2 = c2.next;
            }
        }
        
        even = reverse(even);
        
        c1 = odd;
        c2 = even;
        
        ListNode f1 = null, f2 = null;
        
        while(c2 != null) {
            f1 = c1.next;
            f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
        
        return head;
    }
}
