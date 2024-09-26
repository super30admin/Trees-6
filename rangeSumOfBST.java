/*
Problem: https://leetcode.com/problems/range-sum-of-bst
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

// Recursive
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        if (root.val >= low && root.val <= high)
            return root.val + rangeSumBST(root.left, low, root.val) + rangeSumBST(root.right, root.val, high);
        else if (root.val < low)
            return rangeSumBST(root.right, low, high);
        else if (root.val > high)
            return rangeSumBST(root.left, low, high);
        else
            return 0;
    }
}

// Iterative
class Solution {
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> s = new Stack();
        
        s.push(root);
        
        while(!s.empty()) {
            
            TreeNode n = s.pop();
            
            if (n != null) {
                if(L <= n.val && n.val <= R) {
                    sum += n.val;
                    s.push(n.left);
                    s.push(n.right);
                }

                if(n.val < L)
                    s.push(n.right);
                
                if(n.val > R)
                    s.push(n.left);
            }
        }
        
        return sum;
    }
}