// Time Complexity 
// Space Complexity 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


TC:O(no. of nodes in the tree)
SC:O(height of the tree)
class Solution {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
     
        if(root == null) return sum;
    
        dfsHelper(root,low,high);
     
        return sum;
    }
    
    private void dfsHelper(TreeNode root, int low, int high){
        if(root == null) return;
        
        if(root.val >= low && root.val <= high)
            sum+= root.val;
        
        if(root.val >= low)
            dfsHelper(root.left,low,high);
        
        if(root.val <= high)
            dfsHelper(root.right,low,high);
    }
}