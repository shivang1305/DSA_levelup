/* Date: 04-July-2021 

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:
Try to do it in constant space.

Input 1:
 1 -> 0 -> 0 -> 1

 Input 2:
 0 -> 0 -> 1 -> 1 -> 0

Output 1:
 0 -> 0 -> 1 -> 1

 Output 2:
 0 -> 0 -> 0 -> 1 -> 1


Explanation 1:
 The sorted linked list looks like:
  0 -> 0 -> 1 -> 1

Explanation 2:
 The sorted linked list looks like:
  0 -> 0 -> 0 -> 1 -> 1
*/




public class sort_binary_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode solve(ListNode head) {
        int zeroCount = 0, oneCount = 0; // to count the number of zeroes and ones

        ListNode curr = head;

        // count the number of zeroes & ones
        while(curr != null) {
            if(curr.val == 0)
                zeroCount++;

            else
                oneCount++;

            curr = curr.next;
        }

        ListNode nHead = null;
        curr = nHead;

        // make the new list which has number of zeroes as zero nodes first then one nodes
        // and hence the list is sorted
        while(zeroCount-- > 0) {
            ListNode node = new ListNode(0);
            if(nHead == null) {
                nHead = node;
                curr = node;
            }

            else {
                curr.next = node;
                curr = node;
            }
        }

        while(oneCount-- > 0) {
            ListNode node = new ListNode(1);
            if(nHead == null) {
                nHead = node;
                curr = node;
            }

            else {
                curr.next = node;
                curr = node;
            }
        }
        return nHead;
    }

    // Time complexity = O(N)
    // Space complexity = O(N)

    public ListNode solve2(ListNode head) {
        ListNode curr = head;

        ListNode oneDummy = new ListNode(-1);
        ListNode zeroDummy = new ListNode(-1);

        ListNode c0 = zeroDummy, c1 = oneDummy; 

        // seperating zero and one valued nodes 
        while(curr != null) {
            if(curr.val == 0) {
                c0.next = curr;
                c0 = curr;
            }

            else {
                c1.next = curr;
                c1 = curr;
            }

            curr = curr.next;
        }

        // breaking the last link if any
        c0.next = null;
        c1.next = null;

        // connected all seperated zero and one nodes
        c0.next = oneDummy.next;

        return zeroDummy.next;
    }

    // Time complexity = O(N)
    // Space complexity = O(1)
}
