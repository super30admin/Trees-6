// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root == null){
            return 0;
        }
        return inorder(root,low,high);
    }

    public int inorder(TreeNode root, int low, int high){

        if(root == null){
            return 0;
        }

        int sum = 0;

        //if the current is less than low, no need to check its left because they will also be less than low
        if(root.val > low){
            sum += inorder(root.left,low,high);
        }

        if(root.val >= low && root.val <= high){
            sum += root.val;
        }

        //if the current is greater than high, no need to check its right because they will also be greater than high
        if(root.val < high){
            sum += inorder(root.right,low,high);
        }

        return sum;
    }
}