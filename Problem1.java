//leetcode 938 - Range Sum BST
// TIme - O(N)
// Space - O(n)
class Solution {
    
    int sum = 0;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        helper(root, low, high);
        return sum;
    }
    
    private void helper(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        if(root.val > low ){
            
            
            helper(root.left, low ,high);
        }
        
        if(root.val < high){
            
            helper(root.right, low ,high);
        }
        
        if(low <= root.val && root.val <= high){
            sum  = sum + root.val;
        }
    }
}