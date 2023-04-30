
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

//Time Complexity : O(N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply Inorder traversal and check if the root val is in range between
 * low and high. If so add to result and finally return result.
 *
 */
class Solution {
    int sum = 0;
    int low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        helper(root);
        return sum;
    }

    public void helper(TreeNode root) {
        if(root == null)
            return;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        helper(root.left);
        helper(root.right);
    }
}