//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code run successfully on leetcode : yes
//Any problem you faced while writing this: No
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
class ReangeSumBST {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.result = 0;
        helper(root, low, high);
        return result;    
    }
    private void helper(TreeNode root, int low, int high) {
        //base case
        if(root == null) return;

        //logic
        if(root.val >= low && root.val <= high) result += root.val;

        if(root.val >= low)
            helper(root.left, low, high);
        
        if(root.val <= high)
            helper(root.right, low, high);
    }
}