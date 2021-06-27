public class reverse_alternate_k_nodes {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    static ListNode tempHead = null;
    static ListNode tempTail = null;
    
    public static void addFirst(ListNode node) {
        if(tempHead == null) {
            tempHead = node;
            tempTail = node;
        }
        
        else {
            node.next = tempHead;
            tempHead = node;
        }
    }
    
    public static int length(ListNode node) {
        ListNode curr = node;
        int len = 0;
        
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        
        return len;
    }

    public static ListNode solve(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) // base case
            return head;
        
        ListNode overallHead = null, overallTail = null; // final list ptrs
        ListNode curr = head;
        
        int len = length(head);
        
        boolean flag = true;
        
        while(len >= k) { // till the length of the list is more than k
            int tempK = k;
            
            if(flag == true) { // check to reverse
                flag = false;
                
                while(tempK-- > 0) { // this loop will run k times
                   ListNode forw = curr.next; // backup
                   curr.next = null; // breaking the link
                   
                   addFirst(curr); // add this node in first of temp list
                   curr = forw; // updation of curr ptr
                }
            }
            
            else { // check not to reverse
                flag = true;
                
                tempHead = curr;
                
                ListNode forw = curr; // backup
                while(tempK-- > 1 && forw.next != null)  // this loop will run k times
                   forw = forw.next;
                
                curr = forw.next;
                forw.next = null;
                
                tempTail = forw;
            }
            
            
            // adding temp list in overall list accordingly
            if(overallHead == null) 
                overallHead = tempHead;
            
            else 
                overallTail.next = tempHead;
            
            overallTail = tempTail;
            
            // setting temp list to null again
            tempHead = null;
            tempTail = null;
            
            // decreasing the length of given list by k
            len -= k;
        }
        
        overallTail.next = curr; // for the left out nodes if any which are not grouped in k length groups
        
        return overallHead;
    }

    // Time complexity = O(N)
    // Space complexity = O(1)
}
