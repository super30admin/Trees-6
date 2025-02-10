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
// Approach : DFS - Recursion (Inorder/ Pre Order / Post Order)
// Time : O(N)
// Space : O(N)
class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.result =0;
        if(root == null) return result;
        dfs(root , low , high);
        return result;
    }
    private void dfs(TreeNode root, int low,int high){
        // Base case
        if(root == null) return;

        // Pre Order - condition based recursion
        // logic
        if(root.val >=low && root.val<=high){
            result+=root.val;
        }
        // condition based recursion
        System.out.println(root.val); // 10,5,3,7,15,18 --> [7 , 15] -> [low, high]
        if(root.val > low){
            dfs(root.left,low,high);
        }
        if(root.val < high){
            dfs(root.right,low,high);
        }
        
        
    }
}


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
// Approach : Iterative solution with level order traversal using stack will be preOrder.
// Time : O(N)
// Space : O(N) 
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        Stack<TreeNode> stk = new Stack<>();
        stk.add(root);
        while(!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if(curr.val>=low && curr.val<=high){
                result+=curr.val;
            }
            if(curr.left!=null && curr.val>low){
                // go to left subtree
                stk.add(curr.left);
            }
            if(curr.right!=null && curr.val<high){
                stk.add(curr.right);
            }

        }
        return result;
        
    }
}


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
// Approach : Iterative solution with level order traversal.
// Time : O(N)
// Space : O(N) 
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int result = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val>=low && curr.val<=high){
                result+=curr.val;
            }
            if(curr.left!=null && curr.val>low){
                // go to left subtree
                q.add(curr.left);
            }
            if(curr.right!=null && curr.val<high){
                q.add(curr.right);
            }

        }
        return result;
    }
}