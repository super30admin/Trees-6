/**
Time: O(N) where N is number of nodes in the tree
Space: O(H) where H is height of tree

Approach:
========
1. Traverse the tree in-order and check if every node is in range (L,R)
2. If it is, add it to sum
3. When node value is greater than R, return the result sum
 */
class Solution { 
    int sum; 
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0; 
        sum = 0; 
        inorder(root, L, R);
        return sum; 
    }
    
    private void inorder(TreeNode root, int L, int R) {
        if(root == null)
            return; 
        inorder(root.left, L, R); 
        if( root.val >= L && root.val <= R) 
            sum += root.val; 
        else if(root.val > R)
            return;
        inorder(root.right, L, R); 
    }
}