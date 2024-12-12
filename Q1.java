/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            // process the root
            root = stack.pop();
            if (root.val >= low && root.val <= high)
                sum += root.val;

            if (root.right != null && root.val <= high) {
                stack.push(root.right);
            }
            if (root.left != null && root.val >= low) {
                stack.push(root.left);
            }
        }
        return sum;
    }

    // private int helper(TreeNode root, int low, int high) {
    //     if (root == null)
    //         return 0;
    //     int sum = 0;
    //     if (root.val >= low && root.val <= high)
    //         sum += root.val;

    //     int left = 0;
    //     if (root.val >= low) {
    //         left += helper(root.left, low, high);
    //     }

    //     int right = 0;
    //     if (root.val <= high) {
    //         right += helper(root.right, low, high);
    //     }
    //     return sum + left + right;

    // }
}
