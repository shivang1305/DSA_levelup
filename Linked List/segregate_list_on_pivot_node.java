public class segregate_list_on_pivot_node {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
    
        ListNode(int val) {
          this.val = val;
        }
    }
      
    public static ListNode segregate(ListNode head, int pivotIdx) {
        if(head == null || head.next == null)
          return head;
      
        ListNode curr = head;
        int idx = 0, data = 0;
        
        while(curr != null) {
            if(idx == pivotIdx) {
              data = curr.val;
              break;
            }
              
            idx++;
            curr = curr.next;
        } 
          
        ListNode smaller = new ListNode(-1);
        ListNode larger = new ListNode(-1);
        
        ListNode pivot = null;
        curr = head;
        
        ListNode c1 = smaller, c2 = larger;
        idx = 0;
        
        while(curr != null) {
          if(idx == pivotIdx)
              pivot = curr;
              
          else if(curr.val <= data) {
              c1.next = curr;
              c1 = curr;
          }
          
          else {
              c2.next = curr;
              c2 = curr;
          }
          
          idx++;
          curr = curr.next;
        }
        
        c1.next = pivot;
        pivot.next = larger.next;
        c2.next = null;
        
        return smaller.next;
    }
}
