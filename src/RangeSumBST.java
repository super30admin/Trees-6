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
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        helper(root, low,high);
        return result;
    }
    public void helper(TreeNode root, int low, int high){
        //base
        if(root == null) return;
        //logic
        helper(root.left, low,high);
        helper(root.right, low,high);
        if(root.val >= low && root.val <= high){
            result +=  root.val;
        }
    }
}
