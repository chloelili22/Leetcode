/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create dummy to handle edge cases
      /*
      Dummy Node: A dummy node is used to simplify edge cases and avoid special handling for the head of the merged list. 
      The dummy node is used as a starting point, and a pointer tail is used to keep track of the end of the merged list 
      as elements from list1 and list2 are added.
        */
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null & list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }
            else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // if list1 = [1, 2, 3, 4], list2 = [1, 2],
        // when we compare 1, 2, list2 is null, we can point tail to the rest of list1
        if(list1 != null){
            tail.next = list1;
        }
        else{
            tail.next = list2;
        }
        return dummy.next;
    }
}
