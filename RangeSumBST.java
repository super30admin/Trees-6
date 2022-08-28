//TC,SC - O(n) , o(h)


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
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root); // add root node
        int sum = 0;
        while(!q.isEmpty()){
           
            TreeNode dummy = q.poll();
            sum += (dummy.val >= low && dummy.val <= high) ? dummy.val : 0;
            if(dummy.left != null)
                 q.add(dummy.left);
            if(dummy.right != null)
                 q.add(dummy.right);
              
        }
		return sum;
    }
}
