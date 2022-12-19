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
// TC : O(n)
// SC : O(n)
// Method : Stack
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) return sum;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if(curr.val <= high && curr.val >= low)
                sum = sum + curr.val;
            if(curr.val >= low) {
                if(curr.left != null)
                    st.push(curr.left);
            }
            if(curr.val <= high) {
                if(curr.right != null)
                    st.push(curr.right);
            }
        }
        return sum;
    }
}
