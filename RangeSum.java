public class RangeSum {
    // TC is O(n)
    // SC is O(n)
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val >= low && curr.val <= high){
                result+=curr.val;
            }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
        return result;
    }
}