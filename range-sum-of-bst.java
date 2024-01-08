// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

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
    int total;
    public int rangeSumBST(TreeNode root, int low, int high) {
        total = 0;
        helper(root, low, high);
        return total;
    }
    public void helper(TreeNode root, int low, int high){
        // base
        if(root == null)
            return;
        // logic
        helper(root.left, low, high);
        if(root.val >= low && root.val <= high){
            total += root.val;
        }
        helper(root.right, low, high);
    }
}
