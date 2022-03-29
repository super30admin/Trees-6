// Time Complexity : O(n)
// Space Complexity : O(h) ; height of tree
// Did this code successfully run on Leetcode : Yes

public class RangeSumInBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }

    //inorder
    private void helper(TreeNode root, int low, int high) {
        //base
        if (root == null) return;

        //logic
        helper(root.left, low, high);

        if (root.val >= low && root.val <= high) sum += root.val;
        helper(root.right, low, high);

    }
}
