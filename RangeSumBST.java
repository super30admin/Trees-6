public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTIterative(root, low, high);
    }

    // TC: O(N) where N is number of nodes
    // SC: O(N) where N is number of nodes
    private int rangeSumBSTIterative(TreeNode root, int low, int high) {
        if (root == null) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val >= low && curr.val <= high) {
                res += curr.val;
            }
            if (curr.val > low && curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.val < high && curr.right != null) {
                stack.push(curr.right);
            }
        }
        return res;
    }

    int sum = 0;
    // TC: O(N) where N is number of nodes
    // SC: O(H) where H is depth of tree
    private int rangeSumBSTRecursive(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
