/**
TC: O(n) n: no of nodes.
SC: O(h) h: height of the tree, if skewed then O(n).
Approach: Traverse the tree using DFS and at each node check if its in the range then add it to the result. and if node.val is > low then traverse the left subtree and if node.val < high then traverse the right subTree.
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
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null) return 0;
        int result = 0;
        if(root.val >= low && root.val <= high)
            result += root.val;

        if(root.val > low)
            result += rangeSumBST(root.left, low, high);
        if(root.val < high)
            result += rangeSumBST(root.right, low, high);
        
        return result;
    }
}