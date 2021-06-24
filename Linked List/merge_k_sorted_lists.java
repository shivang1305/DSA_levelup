/* Date: 24-June-2021 

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/


import java.util.*;



public class merge_k_sorted_lists {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /* ---------------------Approach 1 - Using divide and conquer technique------------------*/

    public ListNode mergeTwoSortedLL(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        
        ListNode curr = new ListNode(0);
        ListNode head = curr;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }
        
        if(l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
        
        return head.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si > ei)
            return null;
        
        if(si == ei)
            return lists[si];
        
        int mid = (si + ei) / 2; // divide and conquer approach
        
        ListNode l1 = mergeKLists(lists, si, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, ei);
        
        return mergeTwoSortedLL(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        
        return mergeKLists(lists, 0, lists.length - 1);
    }


// Time complexity = O(N.K.log(K))
// Space complexity = O(1)

    /* -------------------------Approach 2 - Using priority queue ---------------------------*/
    
    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> { // lamda function
            return a.val - b.val; // min value is returned (default behaviour)
        });
        
        for(ListNode l : lists) { // adding the elements in priority queue
            if(l != null)
                pq.add(l);
        }
        
        ListNode curr = new ListNode(0); // dummy node
        ListNode head = curr;
        
        while(!pq.isEmpty()) {
            ListNode node = pq.remove(); // remove from pq
            
            // setting up links and updating the ptrs
            curr.next = node;
            curr = curr.next;
            node = node.next;
            
            if(node != null) // adding the non null elements in the pq 
                pq.add(node);
        }
        
        return head.next;
    }

}