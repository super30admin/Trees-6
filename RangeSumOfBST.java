// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Recursive Approach - Preorder
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }

    public void helper(TreeNode root, int low, int high) {
        if(root == null) return;

        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if(root.val > low)
            helper(root.left, low, high);
        if(root.val < high)
            helper(root.right, low, high);
    }
}
