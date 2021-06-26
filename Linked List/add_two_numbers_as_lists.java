/* Date: 26-June-2021 

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
*/


public class add_two_numbers_as_lists {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, curr = null;
        int sum = 0, carry = 0;
        
        while(l1 != null || l2 != null) {
            
            // put zero if any pointer is null i.e. any list is ended
            int x = (l1 != null) ? l1.val : 0; 
            int y = (l2 != null) ? l2.val : 0;
            
            sum = x + y + carry; 
            
            carry = sum / 10;
            
            ListNode node = new ListNode(sum % 10); // make a new node which stores sum value 
            
            // put it in the ans list accordingly
            
            if(head == null) {
                head = node;
                curr = node;
            }
            
            else {
                curr.next = node;
                curr = node;
            }
            
            if(l1 != null)
                l1 = l1.next;
            
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(carry > 0) { // resolve the case of final carry > 0
            ListNode node = new ListNode(carry); // make a new node for carry value
            
            // add it in ans list in last
            curr.next = node; 
            curr = node;
        }
        
        return head;
    }

    // Time complexity = O(N)
    // Space complexity = O(N)
}
