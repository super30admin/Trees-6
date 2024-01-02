/* Time Complexity : O(n) 
*   n - total number of elements in a tree */
/* Space Complexity : O(h) 
*   h - height of recursive stack */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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

//Int based recursion - DFS
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    private int dfs(TreeNode root, int low, int high){
        //base condn
        if(root == null) return 0;
        //logic
        int curr = 0;
        int left = 0;
        int right = 0;

        if(root.val >= low && root.val <= high){
            curr += root.val;            
        }
        if(root.val >= low)
            left += dfs(root.left, low, high);
        if(root.val <= high){
            right += dfs(root.right, low, high);
        }
        return curr+left+right;
    }
}

//Void based recursion - DFS
/*class Solution {
    int res;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return res;
    }

    private void dfs(TreeNode root, int low, int high){
        //base condn
        if(root == null) return;
        //logic
        if(root.val >= low && root.val <= high){
            res += root.val;            
        }

        if(root.val >= low)
            dfs(root.left, low, high);
        if(root.val <= high){
            dfs(root.right, low, high);
        }

    }
}*/