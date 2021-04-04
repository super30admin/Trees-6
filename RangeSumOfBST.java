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
//DFS
//TC: O(N)
//SC: O(N)
//Dit it run successfully on Leetcode?:Yes
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
         helper(root, low, high);
        return result;
    }
    private void  helper(TreeNode root, int low, int high){
        //base
        if ( root == null){
            return;
        }
        //logic
        if (root.val >= low && root.val <= high)
            result += root.val;
        //if currnet node's value is greater than low only then traverse the left subtree since its a BST left substree will have values less than currnet node
        if (root.val > low){
             helper(root.left, low, high);
        }
        //if currnet node's value is less than high only then traverse the right subtree since its a BST right substree will have values grater than currnet node
        if (root.val < high){
             helper(root.right, low, high);
        }  
    }
}


//BFS
//TC: O(N)
//SC: O(N)
//Dit it run successfully on Leetcode?:Yes
// class Solution {
//     public int rangeSumBST(TreeNode root, int low, int high) {
//         if (root == null)
//             return 0;
//      Queue<TreeNode> q = new LinkedList();
//      q.offer(root);
//      int result = 0;
//         while (!q.isEmpty()){
//             TreeNode curr = q.poll();
//             if (curr.val >= low && curr.val <= high){
//                 result = result + curr.val;
//             }
//             if (curr.val > low && curr.left != null){
//                 q.offer(curr.left);
//             }
//             if (curr.val < high && curr.right != null){
//                 q.offer(curr.right);
//             }    
//         }
//       return result;
//     }
// }
