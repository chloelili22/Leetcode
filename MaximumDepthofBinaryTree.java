/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/
/*
Recursive:
Time Complexity:
O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
Space Complexity:
O(h), where h is the height of the tree. In the worst case (a skewed tree), the recursion stack can go up to the height of the tree.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // The function recursively calls itself for the left and right subtrees to calculate their depths
        // Adding 1 accounts for the current node itself.
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}


// BFS
/*
add(element): Adds an element to the rear of the queue. If the queue is full, it throws an exception.
offer(element): Adds an element to the rear of the queue. If the queue is full, it returns false.
remove(): Removes and returns the element at the front of the queue. If the queue is empty, it throws an exception.
poll(): Removes and returns the element at the front of the queue. If the queue is empty, it returns null.
element(): Returns the element at the front of the queue without removing it. If the queue is empty, it throws an exception.
peek(): Returns the element at the front of the queue without removing it. If the queue is empty, it returns null.
*/
public class Solution{
    public int maxDepth(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null){
            q.add(root);
        }
        int level = 0;

        // loop through the root and add the node into q,
        // remove the current q if there is no children of that
        // increase level
        while(!q.isEmpty()){
            // This line stores the number of nodes currently in the queue, 
            // which represents the number of nodes in the current level of the tree.
            int size = q.size();

/*Why the for loop?
The for loop ensures that we only process nodes from the current level. 
After all nodes of that level are processed, we increment the depth and 
move on to the next level. Without the for loop, we would process nodes
continuously without a clear separation between levels, making it 
impossible to accurately count the depth of the tree.

   3 -> level 1
  /  \
9    20  -> level 2
     / \
    15  7  -> level 3
*/

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            level++;
        }  
        return level;
    }
}
