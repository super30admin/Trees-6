
class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        sum =0;
        dfs(root, low, high);
        return sum;
    }
    private void dfs(TreeNode root, int low, int high)
    {
        if(root == null)
            return;
        if(low <= root.val && root.val <= high)
            sum += root.val;
        if(low < root.val)
            dfs(root.left, low, high);
        if(root.val < high)
            dfs(root.right, low, high);
    }
}