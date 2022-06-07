// O(n) time complexity: n nodes in tree
// O(n) space complexity: recursive call stack

class Solution {
    int ans;
    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                ans += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }
}