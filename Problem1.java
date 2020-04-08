// Time Complexity - O(n) where n is the number of nodes in the tree
// Space Complexity - O(1) 
// This Solution worked on LeetCode

class Solution {
    int result =0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L,R);
        return result;
    }
    private void dfs(TreeNode root,int L,int R){
    // Base Case
        if(root == null) return;
        
    // Logic;
        if(root.val > L)
            dfs(root.left,L,R);
        if(root.val >= L && root.val <= R){
            result += root.val;
            System.out.println(root.val);
        }
        if(root.val < R)
         dfs(root.right,L,R);   
    }
}
