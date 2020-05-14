// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    // int sum=0;
     public TreeNode invertTree(TreeNode root) {
    return  dfs(root);
     }
     public TreeNode dfs(TreeNode root){
         if(root==null){
             return null;
         }
         if(root.left!=null){
           root.left = dfs(root.left);   
         }
        if(root.right !=null){
         root.right = dfs(root.right);
        }
         
         TreeNode temp=root.left;
         root.left=root.right;
         root.right=temp;
         return root;
         
     }
 }