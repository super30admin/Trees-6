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
//TC : O(n)
//SC : O(n)
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        result = 0;
        inorder(root,low,high);
        return result;
    }

    private void inorder(TreeNode root, int low, int high){
        //base
        if(root == null) return;
        //logic
        if(root.val>=low && root.val<=high)
            result += root.val;

        inorder(root.left,low,high);
        inorder(root.right,low,high);
    }
}