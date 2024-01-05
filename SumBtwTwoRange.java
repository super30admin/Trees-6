// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class SumBtwTwoRange {
    class Solution {
        int result;
        public int rangeSumBST(TreeNode root, int low, int high) {
            this.result = 0;
            dfs(root, low, high);
            return result;
        }

        private void dfs(TreeNode root, int low, int high){
            //base
            if(root == null)
                return;

            //logic
            if(root.val >= low && root.val <= high)
                result += root.val;

            if(root.val > low)
                dfs(root.left, low, high);

            if(root.val < high)
                dfs(root.right, low, high);
        }
    }
}
