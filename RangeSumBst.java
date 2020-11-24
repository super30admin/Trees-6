// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    int res=0;
    
    // ******************* DFS Iteractive 
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!= null){
                if(L <= node.val && node.val <= R){
                    res += node.val;
                }
                if(L < node.val){
                    stack.add(node.left);
                }
                if(node.val < R){
                    stack.add(node.right);
                }
            }   
        }
        return res;
    }
    
    
    // ******************* DFS Recursion
    public int rangeSumBST_DFS(TreeNode root, int L, int R) {
        
        dfs(root, L, R);
        return res;
    }
    
    private void dfs(TreeNode root, int L, int R) {
        if(root==null)
            return;
        
        if(L<= root.val && root.val <= R){
            res += root.val;
        }
        if(L < root.val){
            dfs(root.left, L, R);
        }
        if(root.val < R){
            dfs(root.right, L, R);
        }
    }
}