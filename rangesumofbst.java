/*
Time Complexity: O(n)
Space Complexity: O(h) height of the tree
*/
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
//DFS recursive approach
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
       Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null){
            return 0;
        }
        stack.push(root);
        int sum=0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.val && node.val <= high)
                    sum += node.val;
                if (low < node.val)
                    stack.push(node.left);
                if (node.val < high)
                    stack.push(node.right);
            }
        }
        return sum;
    }
}