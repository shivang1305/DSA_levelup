/* Date: 30-June-2021 

1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input Format
    1->2->3->4->5->6->7->null
    7->8->9->null

Output Format
    1->2->3->3->7->7->8->null
*/



public class subtraction_of_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode reverseList(ListNode head) {
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

    public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if(l2 == null)
            return l1;
            
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        int borrow = 0;
        
        ListNode head = null, curr = null;
        
        while(l1 != null) {
            int a = (l1 == null) ? 0 : l1.val;
            int b = (l2 == null) ? 0 : l2.val;
            
            int diff = (a - b) + borrow;
            
            if(diff < 0) {
                borrow = -1;
                diff += 10;
            }
            
            else 
                borrow = 0;
                
            ListNode newNode = new ListNode(diff);
            
            if(head == null) {
                head = newNode;
                curr = newNode;
            }
            
            else {
                curr.next = newNode;
                curr = newNode;
            }
            
            l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;
        }
        
        return reverseList(head);
    }
}
