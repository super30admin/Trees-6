package trees6;

import java.util.Stack;

public class RangeSumOfBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		// Time Complexity : O(n) 
		// Space Complexity : O(n)
		// Did this code successfully run on Leetcode : Yes
		// Any problem you faced while coding this : No
		int sum = 0;
	    public int rangeSumBST(TreeNode root, int low, int high) {
	        dfs(root, low, high);
	        return sum;
	    }
	    
	    private void dfs(TreeNode root, int low, int high) {
	        // null
	        if(root == null)
	            return;
	        
	        // base
	        if(root.val >= low && root.val <= high)
	            sum += root.val;
	        
	        if(root.val >= low)
	            dfs(root.left, low, high);
	        if(root.val <= high)
	            dfs(root.right, low, high);
	    }
		
		int sum1 = 0;
	    public int rangeSumBST1(TreeNode root, int low, int high) {
	        dfs1(root, low, high);
	        return sum1;
	    }
	    
	    private void dfs1(TreeNode root, int low, int high) {
	        // null
	        if(root == null)
	            return;
	        
	        // base
	        if(root.val >= low && root.val <= high)
	            sum1 += root.val;
	        
	        dfs1(root.left, low, high);
	        dfs1(root.right, low, high);
	    }

		public int rangeSumBST2(TreeNode root, int low, int high) {
			if(root == null)
				return 0;

			int sum = 0;
			Stack<TreeNode> st = new Stack<>();

			while(root != null || !st.isEmpty()) {
				while(root != null) {
					st.push(root);
					root = root.left;
				}

				root = st.pop();
				if(root.val >= low && root.val <= high)
					sum += root.val;
				root = root.right;
			}

			return sum;
		}
	}
}
