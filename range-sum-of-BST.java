//TC: O(n), worst case number of nodes between low and high
//SC: O(h), in the worst all the nodes end up in the recursive stack
//running on leetcode: yes
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        dfs(root, low, high);
        return result;
    }
    private void dfs(TreeNode root, int low, int high) {
        if(root == null) {
            return;
        }
        if(root.val >= low) {
            dfs(root.left, low, high);
        }
        if(root.val >= low && root.val <= high) {
                result = result + root.val;
        }
        if(root.val <= high) {
            dfs(root.right, low, high);
        }
    }
}
