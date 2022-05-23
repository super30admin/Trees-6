// Time Complexity : o(n) where n is number of nodes in tree
// Space Complexity : o(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : prune the left nodes if less tahn low and right nodes if greater than high
class Solution {

    int sum =0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }

    public void helper(TreeNode root, int low, int high){

        if(root == null) return;

        if(root.val >= low && root.val<= high){
            sum += root.val;
        }

        if(root.val >= low && root.val<= high){
            helper(root.left, low, high);
            helper(root.right, low, high);
        }
        else if(root.val< low){
             helper(root.right, low, high);
        }
        else if(root.val> high){
               helper(root.left, low, high);
        }

    }
}
