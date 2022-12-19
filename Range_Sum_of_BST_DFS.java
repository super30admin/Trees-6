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
// TC : O(n)
// SC : O(n)
// Method - DFS
class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }
    
    public void dfs(TreeNode root, int low, int high) {
        if(root == null) return;
        
         if(root.val >= low && root.val <= high)
            sum = sum + root.val;
         if(root.val >= low)
             dfs(root.left, low, high);
         if(root.val <= high)
             dfs(root.right, low, high);
    }
}
