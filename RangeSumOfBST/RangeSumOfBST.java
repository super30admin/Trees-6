/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - height of the stack */

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
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                if(root.val >= low){
                    root = root.left;
                } else {
                    root = null;
                }
            }
            root = st.pop();
            if(root.val >= low && root.val <= high){
                res += root.val;
            }
            if(root.val <= high){
                root = root.right;
            } else {
                root = null;
            }
        }
        return res;
    }
}