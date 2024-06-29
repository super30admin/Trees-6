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
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {

        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high)
    {
        if(root == null) return;

        if(root.val >= low && root.val <= high) sum += root.val;

        // Make the dfs call only if the condition is met to optimize unnecessary function calls
        if(root.val > low) dfs(root.left, low, high);

        // Make the dfs call only if the condition is met to optimize unnecessary function calls
        if(root.val < high) dfs(root.right, low, high);
    }
}
