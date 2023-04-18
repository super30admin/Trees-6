// Approach: Conditional recursion for BST
// Time: O(n)
// Space: O(n)
class RangeSumOfBST {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high) {
        // base case
        if (root == null) return;
        // logic
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        if (root.val > low) {
            helper(root.left, low, high);
        }
        if (root.val < high) {
            helper(root.right, low, high);
        }
    }
}