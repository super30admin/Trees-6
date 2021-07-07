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

// Time Complexity : O(N) N being number of nodes in tree
// Space Complexity : O(N)

// DFT
// class Solution {
//    int result=0;
//     public int rangeSumBST(TreeNode root, int L, int R) {
//         if (root == null)
//             return 0;
        
//         rangeSumBST(root.left, L, R);
//         if (root.val >= L && root.val <= R)
//             result+=root.val;
//         rangeSumBST(root.right, L, R);
        
//         return result; 
        
//         //pruning the tree if required
//         if(root.val < L) return rangeSumBST(root.right, L, R);
//         if(root.val > R) return rangeSumBST(root.left, L, R);
//         return root.val+rangeSumBST(root.left, L, R)+rangeSumBST(root.right, L, R);
        
//     }
// }

//BFT
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result=0;
        
        while(!q.isEmpty())
        {
            root=q.poll();
            if(root.val >= L && root.val <= R) {
                result += root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
            } else if(root.val < L) {
                if(root.right != null) q.add(root.right);
            } else {
                if(root.left != null) q.add(root.left);
            }
            
        }
      return result;   
    }
}
