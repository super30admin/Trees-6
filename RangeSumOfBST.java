class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode curr = s.pop();
            if(curr.val >= low && curr.val <= high) {
                sum += curr.val;
            }
            if(curr.val >= low && curr.left != null) {
                s.push(curr.left);
            }
            if(curr.val <= high && curr.right != null) {
                s.push(curr.right);
            }
        }
        return sum;
    }
}