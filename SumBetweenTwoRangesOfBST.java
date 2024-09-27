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
class SumBetweenTwoRangesOfBST {

    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(h)   (where h -> height of the tree)

    private int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return result;
        if(root.val >= low && root.val <= high)
            result += root.val;
        if(root.left != null)
            rangeSumBST(root.left, low, high);
        if(root.right != null)
            rangeSumBST(root.right, low, high);
        
        return result;
    }
}