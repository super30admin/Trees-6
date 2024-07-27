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

//Time - O(n) n is number of nodes
//Space - O(h) h is height
//Approach - Recursive
class RangeSumBST {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return sum;
        helper(root, low, high);
        return sum;
    }
    private void helper(TreeNode root, int low, int high){
        if(root==null){
            return;
        }

        helper(root.left, low, high);

        if(low<=root.val && root.val<=high){
            sum += root.val;
        }

        helper(root.right, low, high);
    }
    class TreeNode {
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
}
