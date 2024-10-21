/* Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
*/


/*
We need to use an array to store the diameter
Primitive types (like int) are passed by value: If we use an int variable, any changes made to it inside the recursive function will not be visible 
outside that function because a copy of the value is passed, not the original.

Reference types (like arrays) are passed by reference: When using an array, the changes made inside the function will persist outside because the
function has a reference to the original array in memory.
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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode root, int[] diameter){
        // base case
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);
    }
}


/*Step-by-Step Execution:
    1
     \
      2
     / \
    3   4
   /
  5

go from node 1 - 2 - 3 - 5 - 3 - 2 - 4 - 2 - 1

Starting at the Root (Node 1):

root = 1
Call dfs(1, res)
DFS on Node 1:

root.left = null, so dfs(null, res) returns 0 (depth of the left subtree is 0).
Then move to the right subtree: root.right = 2, so dfs(2, res) is called.
DFS on Node 2:

Call dfs(3, res) for the left subtree.
DFS on Node 3:

Call dfs(5, res) for the left subtree.
DFS on Node 5:

root.left = null, dfs(null, res) returns 0.
root.right = null, dfs(null, res) returns 0.
Both left and right subtree depths are 0, so res[0] stays 0.
Return 1 (since depth of node 5 is 1 + max(0, 0) = 1).
Back to Node 3:

Left subtree depth is 1 (returned from dfs(5, res)).
root.right = null, so dfs(null, res) returns 0.
No need to update res[0] yet.
Return 2 (since depth of node 3 is 1 + max(1, 0) = 2).
Back to Node 2:

Left subtree depth is 2 (from dfs(3, res)).
Now call dfs(4, res) for the right subtree.
DFS on Node 4:

root.left = null, dfs(null, res) returns 0.
root.right = null, dfs(null, res) returns 0.
Both left and right subtree depths are 0, so no change to res[0].
Return 1 (since depth of node 4 is 1 + max(0, 0) = 1).
Back to Node 2:

Left subtree depth is 2 (from dfs(3, res)).
Right subtree depth is 1 (from dfs(4, res)).
Update res[0] to 3 (path from 5 -> 3 -> 2 -> 4 is the longest path and has 3 edges).
Return 3 (since depth of node 2 is 1 + max(2, 1) = 3).
Back to Root Node (Node 1):

Left subtree depth is 0 (from dfs(null, res)).
Right subtree depth is 3 (from dfs(2, res)).
No need to update res[0], as the longest path (3 edges) has already been found.
Return 4 (since depth of node 1 is 1 + max(0, 3) = 4).
Finally, res[0] contains the diameter of the tree, which is 3.

*/
