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
 //Time - O(n)
 //space - O(n)
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
         dfs(root, low, high);
         return result;
    }
    void dfs(TreeNode root, int low, int high){
          if(root == null) return ;
          
          //action
          if(root.val >=low && root.val<= high){
              result+=root.val;
          }
          dfs(root.left, low, high);
          dfs(root.right, low, high);
      }

}