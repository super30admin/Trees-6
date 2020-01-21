/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null ) return 0;
        
        
        int left= rangeSumBST(root.left,L,R);
        int right= rangeSumBST(root.right,L,R);
        
        if(root.val >= L && root.val <= R) 
          return left+right+root.val;
        else
            return left+right;
        
    }
    
    
}
