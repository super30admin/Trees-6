//Time: O(N) | Space: O(H)

class Solution {
    private int resSum;
    private boolean inRange;
    private boolean stopIterations;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inRange = false;
        dfs(root, low, high);
        return resSum;
    }
    private void dfs(TreeNode root, int low, int high) {
        if(root == null || stopIterations) return;
        dfs(root.left, low,high);
        if(root.val == low) {
            inRange = true;
        }
        if(inRange) resSum += root.val;
        if(root.val == high) {
            inRange = false;
            stopIterations = true;
        }
        if(!stopIterations)
            dfs(root.right, low, high);
    }
} 