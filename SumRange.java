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
/*
method1:
brute force is to check if evrey node is in range, if yes add the value to result

TC: O(n)

method2:  BFS
since its a binary tree, we can make use of its property to eleminate search of some nodes for sure. 
TC: O(n)
SC: O(n)

method 3: dfs
recurisve method


*/
class Solution {
    
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if(root == null){
            return 0;
        }
        this.result = 0;
        
        //method 2 - bfs
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         while(!queue.isEmpty()){
//             TreeNode node = queue.poll();
//             if(node.val >= low && node.val <= high){
//                 result += node.val;
//             }
            
//             if(node.val > low){
//                     if(node.left != null){
//                          queue.add(node.left);
//                     }
//             }
            
//             if(node.val < high){
//                 if(node.right != null){
//                     queue.add(node.right);
//                 }
//             }
            
//         }
        
        //method 3 -dfs
        dfs(root, low, high);
        return result;
    }
    private void dfs(TreeNode node, int low, int high){
        if(node == null){
            return;
        }
        if(node.val >= low && node.val <= high){
            result += node.val;
        }
        if(node.val > low && node.left != null){
            dfs(node.left,low,high);
        }
        if(node.val < high && node.right != null){
            dfs(node.right, low, high);
        }
    }
}