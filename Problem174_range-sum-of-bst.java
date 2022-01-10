// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null) {
                if(L <= node.val && node.val <= R)
                    ans += node.val;
                if(L < node.val)
                    stack.push(node.left);
                if(node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }
}