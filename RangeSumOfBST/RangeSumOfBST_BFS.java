/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - size of the queue */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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

//BFS
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val >= low && curr.val <= high){
                res += curr.val;
            }
            if(curr.left != null && curr.val >= low){
                q.add(curr.left);
            }
            if(curr.right != null && curr.val <= high){
                q.add(curr.right);
            }
        }
        return res;
    }
}