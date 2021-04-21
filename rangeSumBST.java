// Time Complexity : O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

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
    
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
    
        if(root==null) {
            return 0;
        }
        
        dfs(root, low, high);
        return ans;
    }
    
    public void dfs(TreeNode root, int low, int high) {

        if(root==null) {
            return;
        }
        
        if(root.val>=low && root.val<=high) {
            ans += root.val;
        }
        
        if(root.val > low)
            dfs(root.left, low, high);
        if(root.val < high)
            dfs(root.right, low, high);
        
    }
    
}
