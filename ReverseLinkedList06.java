/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {

     // using a singly linkedlist, it only has a next pointer for each node
        ListNode current = head;  // points to the node currently being processed
        ListNode prev = null; // track the previous node
        ListNode nextCurrentV = null; // A temp pointer to store current.next

        /* 
        head = [ 0 ,    1,    2,   3]
        head -> 0 -> 1 -> 2 -> 3 -> null
origin: prev ->current -> next
return: null <- 0 <- 1 <- 2 <- 3 <- head
        prev <- current <- next

        For a linked list like [0 -> 1 -> 2 -> 3 -> null]:
        Before Reversal: head -> 0 -> 1 -> 2 -> 3 -> null
        prev = null; current = 1; nextCurrentV = 2.

        First iteration:
        current.next = prev: 0's next points to null
        pre = current: move prev to current -- prev = 0
        current = nextCurrentV: current = 1
        null <- 0       1 -> 2 -> 3 -> null
      
        second iteration:
        current.next = prev: 1's next points to 0
        pre = current: move prev to current -- prev = 1
        current = nextCurrentV: current = 2
        null <- 0 <- 1      2 -> 3 -> null
        
        third iteration:
        current.next = prev: 2's next points to 1
        pre = current: move prev to current -- prev = 2
        current = nextCurrentV: current = 3
        null <- 0 <- 1 <- 2     3 -> null

        fourth iteration:
        current.next = prev: 3's next points to 2
        pre = current: move prev to current -- prev = 3
        current = nextCurrentV: current = null
        null <- 0 <- 1 <- 2 <- 3  

        now current = null, prev points to 3, which is the new head of the reversed list 
        
        After Reversal: null <- 0 <- 1 <- 2 <- 3 <- head
        
        */

        // current reached null, that means we reach the end of the list
        while(current != null) {
            // assign the pointer of current next at first, then we need to shift current
            nextCurrentV = current.next; 
            current.next = prev; // reverse the next pointer, making the link point backward
            prev = current; 
            current = nextCurrentV;
        }
        return prev;  // Returning prev gives the new head of the reversed linked list.
    }
}

