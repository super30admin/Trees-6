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
    int result=0;
    void recursiveFunction(TreeNode root, int low, int high) {
        //base
        if(root == null) {
            return;
        }
        //logic
        if(root.val >= low && root.val <= high) {
            result = result+root.val;
        }
        recursiveFunction(root.left, low, high);
        recursiveFunction(root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        recursiveFunction(root, low, high);
        return result;
    }
}