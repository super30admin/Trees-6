//TC: O(n) no. of nodes
//SC: O(1) 
//leetcode : successful

class Solution {
    int sum =0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root,low,high);
        return sum;
    }
    public void helper(TreeNode root, int low, int high){
        if(root==null)
            return;
        //inorder
        if(root.left!=null && root.val>=low)
            helper(root.left,low,high);
        if(root.val>=low && root.val<=high)
            sum = sum + root.val;
        if(root.right!=null && root.val<=high)
            helper(root.right,low,high);
    }
}