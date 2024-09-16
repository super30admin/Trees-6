/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Time complexity : O(n)
 * Space Complexity : O(n)
 */
class Solution {
    
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            if(node.val >= L && node.val <= R)
                result = result + node.val;
            
            if(node.val >= L && node.left != null){
                queue.add(node.left);
            }
            
            if(node.val <= R && node.right != null){
                queue.add(node.right);
            }
        }
        
        return result;
    }
}