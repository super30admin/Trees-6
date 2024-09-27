// Time Complexity : O(N), visiting over all nodes in tree
// Space Complexity : O(N), worst case all nodes will be in queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//Use BFS to traverse all the nodes level by level.
//For each node swap the left and right.
//Add the left and right nodes to the queue if each of them is NOT null, like simple BFS.

//BFS version
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            
            TreeNode curr = q.poll();
            
            //swap nodes
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            //add nodes to queue
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
        }
        return root;
    }
}

//=======================================================================================================================

//DFS version

// Time Complexity : O(N), visiting over all nodes in tree
// Space Complexity : O(N) or O(h) worst case all nodes will be called, so h recusrive calls will be made

//Use simple DFS traversal. Call the left node and right node separately and store them in two separte nodes.
//Then swap them.

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}