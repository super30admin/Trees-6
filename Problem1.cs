// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain a global variable sum which I initialize to 0 initially. I perform inorder traversal of the tree, whenever the value of the node lies in the range of [low, high], I add it to the result.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int sum;
    public int RangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        Inorder(root, low, high);
        return sum;
    }

    private void Inorder(TreeNode root, int low, int high)
    {
        if(root == null)
        {
            return;
        }

        Inorder(root.left, low, high);
        
        if(root.val>=low && root.val<=high)
        {
            sum += root.val;
        }

        Inorder(root.right, low, high);
    }
}