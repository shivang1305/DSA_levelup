/* Date: 04-July-2021 

Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.

The steps of the insertion sort algorithm:

Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
It repeats until no input elements remain.
The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.

Input: head = [4,2,1,3]
Output: [1,2,3,4]

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
*/



public class insertion_sort_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        //edge cases
        if(head == null || head.next == null)
            return head;
        
        ListNode start = head;
        ListNode curr = head.next;
        
        while(curr != null) {
            start = head;
            //taking start from head to curr pointer and compare all the values and swapping the required values
            while(start != curr) {
                if(start.val > curr.val) {
                    // swap the values 
                    int t = start.val;
                    start.val = curr.val;
                    curr.val = t;
                }
                start = start.next;
            }
            curr = curr.next;
        }
        
        return head;
    }
}
