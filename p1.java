// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

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

 //Iterative post order solution
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        TreeNode curr = root;
        TreeNode prev = null;
        int result = 0;
        Stack<TreeNode> stk = new Stack<>();
        while(curr != null || !stk.isEmpty()){
            if(curr.left == prev){
                if(curr.right != null && curr.val < high){
                    prev = curr;
                    curr = curr.right;
                } else{
                    // System.out.println(curr.val);
                    if(low <= curr.val && high >= curr.val) result += curr.val;
                    prev = curr;
                    stk.pop();
                    if(!stk.isEmpty()){
                        
                        curr = stk.peek();
                    } else{
                        curr = null;
                    }
                    
                }
            } else if(curr.right == prev){
                stk.pop();
                // System.out.println(curr.val);
                if(low <= curr.val && high >= curr.val) result += curr.val;
                prev = curr;
                if(!stk.isEmpty()){
                    curr = stk.peek();
                } else{
                     curr = null;
                }
            } else if(curr.left != null && curr.val > low){
                stk.add(curr);
                prev = curr;
                curr = curr.left;
            } else if(curr.right != null && curr.val < high){
                stk.add(curr);
                prev = curr;
                curr = curr.right;
            }else {
                // System.out.println(curr.val);
                if(low <= curr.val && high >= curr.val) result += curr.val;
                prev = curr;
                if(!stk.isEmpty()){
                    curr = stk.peek();
                } else{
                     curr = null;
                }
            }
        }
        return result;
    }
}