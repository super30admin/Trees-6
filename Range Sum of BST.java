// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // int sum=0;
     public int rangeSumBST(TreeNode root, int L, int R) {
         if(root == null) return 0;
         if(root.val >= L && root.val <=R)
         {
         return rangeSumBST(root.left,L,R)+root.val+rangeSumBST(root.right,L,R);
         }
         else if(root.val <L){  return rangeSumBST(root.right,L,R);
                         }
        return rangeSumBST(root.left,L,R);
     }
    
 }