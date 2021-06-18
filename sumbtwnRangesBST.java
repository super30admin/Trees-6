// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        // helper(root,low,high);
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            if(curr.val >= low && curr.val <= high) sum += curr.val;
            if(curr.val >= low && curr.left != null) s.push(curr.left);
            if(curr.val <= high && curr.right != null) s.push(curr.right);
            
        }
        return sum;
 
    }
    private void helper(TreeNode root,int low,int high){
        //base
        int sum = 0;
        if(root == null) return;
        //action
        if(root.val >= low && root.val <= high) sum+= root.val;
        if(root.val >= low) helper(root.left,low,high);
        if(root.val <= high) helper(root.right,low,high);
        
    }
}
