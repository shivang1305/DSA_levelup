/* Date: 23-June-2021 

Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln

Input Format
1->7->2->6->3->5->4->null

Output Format
1->2->3->4->5->6->7->null
*/


public class unfold_linked_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode revOfList(ListNode head) {
        if(head == null || head.next == null)
            return head;
            
        ListNode prev = null, curr = head, forw = null;
        
        while(curr != null) {
            forw = curr.next;
            
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

    public static void unfold(ListNode head) {
        ListNode fh = head, sh = head.next, fp = fh, sp = sh, f = null;
        
        while(sp != null) {  // O(N)
            f = sp.next; // backup ptr to set links
            
            fp.next = f; // to break the link
            if(f != null) // to avoid null pointer exception in case of odd length list
                sp.next = f.next;
            
            // update the pointers
            fp = fp.next;
            sp = sp.next;
        }
        
        sh = revOfList(sh);
        
        
        fp = fh;
        while(fp.next != null)
            fp = fp.next; 
            
        fp.next = sh; // merging both the lists again
    }
}
// Time complexity = O(N)
// Space complexity = O(1)