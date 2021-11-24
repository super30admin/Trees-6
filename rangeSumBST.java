// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// iterative preorder traversal
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        int result = 0;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            if(root.val >= low && root.val <= high){
                result += root.val;
            }
            if(root.val > low && root.left != null)
                st.push(root.left);
            
            if(root.val < high && root.right != null)
                st.push(root.right);
            
            
        }
        return result;
    }
}

// *********************************************

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Brute Force: using property of BSTs
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        Stack<TreeNode> st = new Stack<>();
        int result = 0;
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(root.val >= low && root.val <= high)
                result += root.val;
            root = root.right;
        }
        return result;
    }
}
