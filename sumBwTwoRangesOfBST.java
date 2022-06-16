//TC: O(n) because in worst case we will be going through all the nodes
//SC: O(n) space for recursion

//CODE:
class Solution {
    int sum =0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        helper(root,low,high);
        return sum;
    }
    
    public void helper(TreeNode root , int low , int high){
        if(root == null) return ;
        
        if(root.val >= low){
            helper(root.left,low,high);
        }
        
        if(root.val >= low && root.val<= high){
            sum = sum+root.val;
        }
        
        if(root.val <= high){
            helper(root.right , low , high);
        }
    }
}