/* Date: 28-June-2021 

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
*/

import java.util.*;

public class copy_list_with_random_pointers {

    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /*--------------------------- Approach 1 - Using HashMap --------------------------------*/
    
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head, copyHead = null, copyCurr = head;
        
        while(curr != null) {
            Node copyNode = new Node(curr.val); // creating new node from orignal list
            
            map.put(curr, copyNode); // put the nodes in hashmap which actually maps the address
            
            // adding the copynode to the new list
            if(copyHead == null) {
                copyHead = copyNode;
                copyCurr = copyNode;
            }
            
            else {
                copyCurr.next = copyNode;
                copyCurr = copyCurr.next;
            }
            
            curr = curr.next; // updation
        }
        
        curr = head;
        while(curr != null) {
            Node copyNode = map.get(curr);
            // upadting the random ptr of copy node from hashmap (if not null)
            copyNode.random = (curr.random != null) ? map.get(curr.random) : null;
            
            curr = curr.next;
        }
        
        return copyHead;
    }
    // Time Complexity = O(n)
    // Space Complexity = O(n)

    /*----------------------- Approach 2 - Without using extra space ------------------------*/
    
    public Node copyRandomList2(Node head) {
        if(head == null)
            return head;
        
        Node curr = head, forw = null;
        
        // making the copy of each node in linked list and attaching the copied node to the next of orignal node
        while(curr != null) {
            forw = curr.next;
            
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = forw;
            
            curr = forw;
        }
        
        curr = head;
        
        // settling the random pointers of the copied linked list
        while(curr != null && curr.next != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }
        
        curr = head;
        
        Node dummy = new Node(-1);
        Node prev = dummy;
        
        // seperating orignal and copied lists
        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            prev = prev.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    // Time complexity = O(N)
    // Space complexity = O(1)
}