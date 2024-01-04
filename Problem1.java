// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;
    }
    public void helper(TreeNode root, int low, int high){
        if(root == null)
            return;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        helper(root.left,low,high);
        helper(root.right,low,high);
    }
}