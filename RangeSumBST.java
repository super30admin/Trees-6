// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    
    int result;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null) return 0;
        
        dfs(root, low, high);
        
        return result;
    }
    
    private void dfs(TreeNode root, int low, int high) {
        
        if(root == null) return;
        
        if(root.val >= low && root.val <= high) {
            result += root.val;
        }
        
        if(root.val > low) dfs(root.left, low, high);
        if(root.val < high) dfs(root.right, low, high);
    }
}