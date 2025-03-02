package Trees-6;

public class RangeSum{

    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    public int dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return dfs(root.right, low, high);
        }
        if (root.val > high) {
            return dfs(root.left, low, high);
        }

        return root.val + dfs(root.left, low, high) + dfs(root.right, low, high);
    }
}