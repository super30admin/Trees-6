// Time Complexity : O(n)    
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of dfs to solve this problem


class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return result;
        dfs(root, low, high);
        return result;
    }
    
    public void dfs(TreeNode root, int low, int high){
        if(root == null)return;
        if(root.val>=low)
            dfs(root.left, low, high);
        if(root.val>= low && root.val<= high)
            result+=root.val;
        if(root.val<=high)
            dfs(root.right, low, high);
    }
}

// Time Complexity : O(n)    
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We make use of bfs to solve this problem

class Solution {
    int result;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val>=low)
                if(curr.left!=null )
                    q.add(curr.left);
            if(curr.val>= low && curr.val<= high)
                result += curr.val;
            if(curr.val<=high){
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}