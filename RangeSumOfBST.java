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

// Time Complexity : O(n) n-> no of nodes in the tree
// Space Complexity : O(n) stack space in DFT, queue space in BFT
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach: Depth first traversal
/*
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        
        if(root.val >= L && root.val <= R) {
            return rangeSumBST(root.left, L, R) + root.val + rangeSumBST(root.right, L, R);
        }
        
        if(root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        
        return rangeSumBST(root.left, L, R);
    }
}
*/

//Approach: Breadth first traversal
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.val >= L && curr.val <= R) {
                sum += curr.val;
                if(curr.left != null) 
                    q.offer(curr.left);
                if(curr.right != null) 
                    q.offer(curr.right);
            }
            else if(curr.val < L) {
                if(curr.right != null) 
                    q.offer(curr.right);
            }
            else {
                if(curr.left != null) 
                    q.offer(curr.left);  
            }
        }
        return sum;
    }
}
