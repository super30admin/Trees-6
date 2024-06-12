//TC - O(N)
//SC - O(H)
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	int result;

	public int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return result;
		dfs(root, L, R);
		return result;
	}

	private void dfs(TreeNode root, int L, int R) {
		// base case
		if (root == null)
			return;
		// logic
		if (root.val >= L && root.val <= R) {
			result += root.val;
		}
		if (root.val > L) {
			dfs(root.left, L, R);
		}
		if (root.val < R) {
			dfs(root.right, L, R);
		}
	}
}
