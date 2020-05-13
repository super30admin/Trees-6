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

// Time Compexity: O(N)
// Space Complexity: O(N), uses BFS

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
    	Queue<TreeNode> queue = new LinkedList<>();

    	int result = 0;

    	queue.add(root);

    	while(!queue.isEmpty()) {
    		root = queue.poll();

    		if(root.val >= L && root.val <= R) {
    			result += root.val;
    			if(root.left != null) queue.add(root.left);
    			if(root.right != null) queue.add(root.right);
    		} else if(root.val < L) {
    			if(root.right != null) queue.add(root.right);
    		} else {
    			if(root.left != null) queue.add(root.left);
    		}
    	}

    	return result;
        
    }
}