//Time: O(N) | Space: O(H)

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
    private int resSum;
    private boolean inRange;
    private boolean stopIterations;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inRange = false;
        dfs(root, low, high);
        return resSum;
    }
    // in-order traversal
    private void dfs(TreeNode root, int low, int high) {
        if(root == null || stopIterations) return;
        dfs(root.left, low,high);
        if(root.val == low) {
            inRange = true;
        }
        if(inRange) resSum += root.val;
        if(root.val == high) {
            inRange = false;
            stopIterations = true;
        }
        if(!stopIterations)
            dfs(root.right, low, high);
    }
}