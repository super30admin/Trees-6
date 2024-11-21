TC: O(n)
SC: O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Sum of BST.
Memory Usage: 48.4 MB, less than 69.19% of Java online submissions for Range Sum of BST.

Approach: If a node's value is between the range add it to total. If it is less that right goto it right 
child and if it is greater than its left goto its left child.


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
    int L;
    int R;
    int total = 0;
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null ) return total;
        
        this.L = L;
        this.R = R;
        
        recursive(root);
        
        return total;
        
        
    }
    private void recursive(TreeNode root){
        if(root == null ) return ;
        
        //recursive
        if(root.val <= R && root.val >= L){
            total+= root.val;
        }
        if(root.val > L)  recursive(root.left);
        if(root.val < R)  recursive(root.right);
        
    }
    
}
