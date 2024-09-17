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
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        return dfs(root, low, high);
        
    }
    
    private int dfs(TreeNode root, int low, int high){
        //base
        if(root == null) return 0;
        // if(root.val >= low && root.val <= high) return root.val;
        
        //logic
        //root --> preorder
        
        int result = 0;
        
        if(root.val > low){
            result += dfs(root.left, low, high);
        }
        
        //st.pop()
        //root --> inorder
        
        if(root.val < high)
            
            result += dfs(root.right, low, high);
            //st.pop();
            //root --> postorder
            
        if(root.val >= low && root.val <= high) result += root.val;
        return result;
        
    }
}

//TC: O(H)
//SC: O(1)
