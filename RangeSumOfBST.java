//Time - O(n)
//Space - O(n)

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
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        
        return helper(root, L, R);
    }
    
    private int helper(TreeNode root, int L, int R){
        //base
        if(root == null)
            return 0;
        //logic
        //If the root value is in between L and R eplore both left and right sub tree
        if(root.val >= L && root.val <= R){
            return root.val + helper(root.left, L, R) + helper(root.right, L, R);
        }
        // if currr val is less than L explore right sub tree
        if(root.val < L){
           return  helper(root.right, L, R);
        }
        
        if(root.val > R){
            return helper(root.left, L, R);
        }

        return 0;
    }
    
}
