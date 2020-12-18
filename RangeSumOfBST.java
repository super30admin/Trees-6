// Time Complexity : O(n), traverse all nodes
// Space Complexity : O(n), worst case, O(log n) VG 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// inorder traversal with checks

class Solution {
    int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum;
    }
    
    private void helper(TreeNode node, int low, int high){
        if(node==null)
            return;
        
        if(node.val>low)
            helper(node.left, low, high);
        if(node.val>=low && node.val<=high)
            sum += node.val;
        if(node.val<high)
            helper(node.right, low, high);
    }
}