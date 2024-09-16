// Time Complexity : O(n) --> where n is the number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (938): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.result = 0;
        if (root == null) return result;
        dfs(root, L, R);
        return result;
    }
    private void dfs(TreeNode root, int L, int R) {
        // base
        if (root == null) return;
        
        // logic
        if (root.val >= L && root.val <= R) result += root.val;
        if (root.val > L) dfs(root.left, L, R);
        if (root.val < R) dfs(root.right, L, R);
    }
}