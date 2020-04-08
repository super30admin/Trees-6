/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time complexity : O(n)
 * Space Complexity : O(H)
 */
class Solution {
    
    int result = 0;
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        if(root == null){
            return 0;
        }    
        
        helper(root, L, R);
        return result;
    }
    
    private void helper(TreeNode root, int L, int R){
        //Base condition
        if(root == null){
            return;
        }
        
        //Logic
        if(root.val >= L){
            
            helper(root.left, L, R);
        }
        
        if(root.val >= L && root.val <= R){
            result = result + root.val;
        }
        
        if(root.val <= R){
            helper(root.right, L, R);
        }
    }
}