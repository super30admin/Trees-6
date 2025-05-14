
/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Utilizing the BST property,
 * left child is less than or equal to parent and all on right tree has greater than parent
 */

public class RangeSumOfBst {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {
        // base
        if (root == null)
            return;

        // logic
        if (root.val > low)
            dfs(root.left, low, high);

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val < high)
            dfs(root.right, low, high);
    }
    public static void main(String[] args) {
        // Your code here
    }
}