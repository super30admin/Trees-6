// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//938. Range Sum of BST (Easy) - https://leetcode.com/problems/range-sum-of-bst/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
//class Solution {
//
//	int result;
//
//	public int rangeSumBST(TreeNode root, int low, int high) {
//		helper(root, low, high);
//
//		return result;
//	}
//
//	private void helper(TreeNode root, int low, int high) {
//		// base
//		if (root == null)
//			return;
//
//		// logic
//		if (root.val >= low && root.val <= high) {
//			result += root.val;
//		}
//
//		helper(root.left, low, high);
//
//		helper(root.right, low, high);
//	}
//}

// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
//class Solution {
//
//	public int rangeSumBST(TreeNode root, int low, int high) {
//		return helper(root, low, high);
//
//		return result;
//	}
//
//	private void helper(TreeNode root, int low, int high) {
//		// base
//		if (root == null)
//			return;
//
//		// logic
//		if (root.left != null && root.val > low) {
//			helper(root.left, low, high);
//		}
//
//		if (root.val >= low && root.val <= high) {
//			result += root.val;
//		}
//
//		if (root.right != null && root.val < high) {
//			helper(root.right, low, high);
//		}
//	}
//}

// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
//class Solution {
//
//	public int rangeSumBST(TreeNode root, int low, int high) {
//		return helper(root, low, high);
//	}
//
//	private int helper(TreeNode root, int low, int high) {
//		// base
//		if (root == null)
//			return 0;
//
//		// logic
//		int temp = 0;
//		if (root.val >= low && root.val <= high) {
//			temp = root.val;
//		}
//
//		int left = helper(root.left, low, high);
//
//		int right = helper(root.right, low, high);
//
//		return temp + left + right;
//	}
//}

// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
//class Solution {
//	public int rangeSumBST(TreeNode root, int low, int high) {
//		Stack<TreeNode> stack = new Stack<>();
//		int result = 0;
//
//		while (root != null || !stack.isEmpty()) {
//			while (root != null) {
//				stack.push(root);
//				root = root.left;
//			}
//
//			root = stack.pop();
//
//			if (root.val >= low && root.val <= high) {
//				result += root.val;
//			}
//
//			root = root.right;
//		}
//
//		return result;
//	}
//}

// Time Complexity : O(n) where n = number of nodes
// Space Complexity : O(h) where h = height of the tree
class Solution {
	public int rangeSumBST(TreeNode root, int low, int high) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		int result = 0;

		while (!stack.isEmpty()) {
			root = stack.pop();

			if (root.val >= low && root.val <= high) {
				result += root.val;
			}

			if (root.right != null && root.val <= high) {
				stack.push(root.right);
			}

			if (root.left != null && root.val >= low) {
				stack.push(root.left);
			}
		}

		return result;
	}
}