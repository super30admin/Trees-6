/*
Time: O(N) where N is number of nodes in tree
Space: O(H) where H is height of the tree (recursive stack)
Approach: 
========
1. Swap left and right nodes of every node starting with root
2. Recursively call inversion method on its left and right subtrees 
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root; 
        helper(root); 
        return root;
    }
    
    private void helper(TreeNode root) {
        if( root == null) return ;
        //swap left and right nodes
        TreeNode node = root.left; 
        root.left = root.right;
        root.right = node;
        //invert left subtree nodes top-down
        helper(root.left); 
        // invert right subtree nodes top-down
        helper(root.right); 
    }
}
