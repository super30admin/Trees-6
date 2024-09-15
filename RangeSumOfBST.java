// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        
        inorder(root, low, high);
        
        return sum;
    }
    
    private void inorder(TreeNode root, int low, int high) {
        if(root == null) {
            return;
        }
        
        if(root.val > low) {
            inorder(root.left, low, high);
        }
        
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        
        if(root.val < high) {
            inorder(root.right, low, high);
        }
    }
}