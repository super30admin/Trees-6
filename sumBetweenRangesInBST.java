// Time Complexity = O(n)
// Space Complexity = O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// This question can be solved using any order of traversal and either DFS or BFS
// We only call dfs on left child if (root.val >= low) and on right child if (root.val <= high)
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        dfs(root, low, high);
        return result;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val >= low) {
            dfs(root.left, low, high);
        }

        if(root.val >= low && root.val <= high) {
            result += root.val;
        }

        if (root.val <= high) {
            dfs(root.right, low, high);
        }
    }
}