
// Time Complexity : 0(n)
// Space Complexity : O(n)
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
    //aesha
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high)
    {
        if(root ==null) return;
        
        if(root.val >= low && root.val<= high) 
        {
            result+=root.val;
        }
        helper(root.left, low, high);
        helper(root.right, low, high);

    }
}