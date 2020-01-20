//Time Complexity: O(n) as I would viist each node only once
//Space complexity: O(1)
/*Approach: Did inorder traversal of the tree to get ascending order, and whenever thhe root val is>= L and root value is <= R I add to the resultant sum.
*/

class Solution {
    int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root,L,R);
        return sum;
        
    }
    private void helper(TreeNode root, int L, int R){
        if(root==null) return;
        
        if(root.left!=null) helper(root.left,L,R);
        
        if(root.val>=L&&root.val<=R) sum+=root.val;
        
        if(root.right!=null) helper(root.right,L,R);
    }
}
