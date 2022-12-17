// Time Complexity: O(N), n == nubmer of elements in the BST
// Space Complexity: O(H), H == depth of the BST
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
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        // base condition
        if (root == null) return;


        //recurse left
        if (root.val > low) {
            dfs(root.left, low, high);
        }

        // recurse
        if (root.val < high) {
            dfs(root.right, low, high);
        }

        // logic
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
    }
}