// TC: O(n)
// SC: O(h) recursive stack
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result;

    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        helper(root, low, high);
        return result;
    }

    private void helper(TreeNode root, int low, int high){
        if(root == null) {
            return;
        }

        helper(root.right, low, high);
        helper(root.left, low, high);

        if((root.val <= high) && (root.val >= low)){
            result = result + root.val;
        }
    }
}