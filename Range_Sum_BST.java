// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        sum =0;
        inorder(root, low, high);
        return sum;
    }
    private void inorder(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        if(root.val > low){
            inorder(root.left, low, high);
        }
        if(root.val >= low && root.val <= high){
            sum += root.val;
        }
        if(root.val < high){
            inorder(root.right, low, high);
        }
    }
}