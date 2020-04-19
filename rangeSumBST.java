// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class rangeSumBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        helper(root, L, R);
        return ans;
    }
    private void helper(TreeNode root, int L, int R) {
        if (root != null) {
            if (root.val <= R && root.val >= L) 
                ans += root.val;
            if (root.val > L)
                helper(root.left, L, R);
            if (root.val < R)
            helper(root.right, L, R);
        }
    }
}

