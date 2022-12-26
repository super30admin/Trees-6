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
        if(root.left!=null && root.val>low)
            helper(root.left,low,high);
        if(root.val>=low && root.val<=high)
            sum = sum + root.val;
        if(root.right!=null && root.val<high)
            helper(root.right,low,high);
    }
}

//with return int func;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
        
    }
    public int helper(TreeNode root, int low, int high){
        if(root==null)
            return 0;
        int temp = 0,left =0, right=0;
        //inorder
        if(root.left!=null && root.val>low) 
            left = helper(root.left,low,high);
        if(root.val>=low && root.val<=high)
            temp = root.val;
        if(root.right!=null && root.val<high) //no equals sign
            right = helper(root.right,low,high);
        return temp + left+right;
    }
}