//Time Complexity: o(n)
//Space Complexity: o(n)
//Expln: Perform normal bfs in the bst and add the left and right childs only when the root is > low and < high.
// in this way we save a bit of complexity and pop the element and if its in the index add it to the results
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
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null) continue;
            if(curr.val >= low && curr.val <= high)
                result += curr.val;
            if(curr.val > low)
                q.add(curr.left);
            if(curr.val < high)
                q.add(curr.right);
        }
        return result;
    }
}