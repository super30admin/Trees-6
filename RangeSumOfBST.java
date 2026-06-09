// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We do a BFS traversal using queue and add root first. Later we add only those nodes whose values lie between
the low and high range to the queue to further explore. We also have a sum variable to keep track of total
sum by checking if the current node's value lies between low and high.
 */
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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null && curr.val > low) {
                q.add(curr.left);
            }
            if(curr.right != null && curr.val <= high) {
                q.add(curr.right);
            }
            if(curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }
        }
        return sum;
    }
}