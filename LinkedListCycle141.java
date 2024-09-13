/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
*/


/*
Floyd's Tortoise and Hare Algorithm:
The slow pointer moves one step at a time.
The fast pointer moves two steps at a time.
If the linked list has a cycle, the fast pointer will eventually "lap" the slow pointer (i.e., they will meet at some point inside the cycle).
If there is no cycle, the fast pointer will reach the end of the list (i.e., null).


Time Complexity:
O(n), where n is the number of nodes in the linked list. Both the slow and fast pointers traverse the list at most n steps.
Space Complexity:
O(1), since only two additional pointers (slow and fast) are used, making the space complexity constant.
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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;  // slow moves one step at a time
            fast = fast.next.next; // fast moves two steps at a time

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
