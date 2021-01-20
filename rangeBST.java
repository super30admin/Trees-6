// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution

//DFS version

// Your code here along with comments explaining your approach
// We use the concept of BST and range value to traverse the tree recursively. 
// If root value is less than the lowest range, then this means all the roots in the left side is lower than the root value. Since, the root is lower than lowest range it won't be taken, therefore it's left child's won't be considered.
//Same goes for root value higher than highest possible range value.

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        
        return dfs(root, L, R);
    }
    
    private int dfs(TreeNode root, int L, int R){
        
        if(root == null) return 0;
        
        if(root.val >= L && root.val <= R){
            return dfs(root.left, L, R) + root.val + dfs(root.right, L, R);
        }else if(root.val < L){ //if root value is less than the lowest range, then this means all the roots in the left side is lower than the root value. Since, the root is lower than lowest range it won't be taken, therefore it's left child's won't be considered.
            return dfs(root.right, L, R);
        }else{//same applies, if root value is greater than highest range
            return dfs(root.left, L, R);
        }
      
    }
}


//==================================================================================================================================================================

//BFS
//We use BFS traversal. We add the root value to result only if it's within the range (inclusive). We also add both the left and right only if the previous condition satisfies.
//Else, if root.val < lowest range, then we add only the right child.
//Else, we add only the left child.

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
      
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int result = 0;
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            if(curr.val >= L && curr.val <= R){                
                result += curr.val;               
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }else if(curr.val < L){
                if(curr.right != null) q.offer(curr.right);
            }else{
                if(curr.left != null) q.offer(curr.left);
            }
            
        }
        
        return result;
    }
}