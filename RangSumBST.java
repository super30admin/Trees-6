/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
    bst(root, low, high);
        return sum;
    }
       public void bst(TreeNode root, int low, int high){
           
            if(root==null){return;}
           
        bst(root.left,low,high);
           
        if(root.val<=high&&root.val>=low){ sum+=root.val;}
           
     bst(root.right,low,high);   
        
       }         
                
                
                
                
}
